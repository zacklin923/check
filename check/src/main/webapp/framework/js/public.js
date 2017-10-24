/**
 * 张顺，2017-9-12
 * 1、本文件为公共js文件，所有html均需引入该文件
 * 2、本文件使用的库有：jquery、json2、easyUI，在实际编写html时，务必记得在之前引入相应的库
 * 3、请不要修改pullRequest的参数，如果pullRequest已经不能满足要求，请另写一个函数继承它
 */

//var URL_PATH="http://web.szexpress.com.cn:15507";//url的前面部分，包含协议、ip、端口。——张顺，2017-9-12
var URL_PATH="http://172.16.1.37:8080";//黄光辉
//var URL_PATH="http://web.szexpress.com.cn:15506";//正式库的地址

/**获取token*/
function getToken(){
	var tokenNuber =  window.localStorage.getItem("token");
	return tokenNuber;	
}
/**存储token*/
function setToken(token){
	window.localStorage.setItem("token",token);
}
/**删除token*/
function removeToken(token){
	window.localStorage.removeItem("token");
}

/**判断是否是json对象或者json数组*/
function isJson(obj){
	var isj = typeof(obj) == "object" && (Object.prototype.toString.call(obj).toLowerCase() == "[object object]" || Object.prototype.toString.call(obj).toLowerCase() == "[object array]"); 
	return isj;
}
/**
 * @author 张顺
 * @see 2017-9-12，封装访问接口方法，做一些预处理动作，具体页面中只需写自己的业务逻辑相关代码，而不必关心其他东西
 * @param urlb： url后面的部分，默认空字符串
 * @param type： 请求类型，比如：get、post、put、delete，默认get
 * @param async： 是否异步 true、false，默认true
 * @param data： json对象，需要传的参数，默认空json对象
 * @param success 成功时调用的函数,其函数参数为success(data)
 * @param error 失败时执行的函数，注意并不是网络问题导致的失败，是成功接收，只是result=='error'，其函数参数为error(code,data)
 * @param isNeedToken: 是否需要判断token是否存在，true判断，false不判断，默认true
 * */
function pullRequest(options){
	var urlb,type,async,data,success,error,isNeedToken;
	if(options){
		urlb=options.urlb?options.urlb:"";
		type=options.type?options.type:"get";
		async=typeof(options.async)!="undefined"?options.async:true;
		data=options.data?options.data:{};
		success=options.success?options.success:function(data){};
		error=options.error?options.error:null;
		isNeedToken=typeof(options.isNeedToken)!="undefined"?options.isNeedToken:true;
		var url = URL_PATH+urlb;
	    var token=getToken();
	    var isNext=false;//是否继续的标志
	    if(isNeedToken){
	    	if(token){
	    		isNext=true;
	    	}else{
	        	alert("token为空，可能需要重新登录。");
	        }
	    }else{
	    	isNext=true;
	    }
	    if(isNext){
	    	$.ajax({
	        	url:url,
	        	type:type,
	        	async:async,
	        	data:data,
	        	beforeSend: function (request) {
	    	        request.setRequestHeader("token", token);
	    	    },
	        	success:function(data){
	        		if(data){
	        			var json;
	        			if(isJson(data)){
	        				json=data;
	        			}else{
	        				json=JSON.parse(data);
	        			}
	        			if(json.result=="success"){
	        				success(json.data);	
	        			}else if(json.result=="error"){
	        				if(error){
	        					error(json.code,json.data);
	        				}else{
	        					alert("错误。\n错误代码："+json.code+"。\n错误参数："+json.data);
	        				}
	        			}
	        		}else{
	        			alert("返回值为空，可能接口出错，请检查后台错误日志。");
	        		}
	        	},
	        	error:function(XMLHttpRequest, textStatus, errorThrown) {
	        		alert("status:"+XMLHttpRequest.status+"\nreadyState:"+XMLHttpRequest.readyState+"\ntextStatus:"+textStatus);
	    	    }
	        });
	    }else{
	    	alert("函数中止，请检查参数设置。");
	    }
	}else{
		alert("错误：参数为空，请检查代码。");
	}
    
}
/*张顺，2017-3-3，查询栏位的查询函数，这里需要注意几个id不能改变：1、查询栏位表单id固定为search。2、表格id固定为dg。*/
function formToJson(formObj){
   var o={};
   var a=formObj.serializeArray();
   $.each(a, function() {
       if(this.value){
           if (o[this.name]) {
               if (!o[this.name].push) {
                   o[this.name]=[ o[this.name] ];
               }
                   o[this.name].push(this.value || null);
           }else {
               if($("[name="+this.name+"]:checkbox",formObj).length){
                   o[this.name]=[this.value];
               }else{
                   o[this.name]=this.value || null;
               }
           }
       }
   });
   return o;
}
/*form表单转json对象*/
$.fn.serializeObject = function(){    
   var o = {};    
   var a = this.serializeArray();    
   $.each(a, function() {    
       if (o[this.name]) {    
           if (!o[this.name].push) {    
               o[this.name] = [o[this.name]];    
           }    
           o[this.name].push(this.value || '');    
       } else {    
           o[this.name] = this.value || '';    
       }    
   });    
   return o;    
};
/*form表单转url参数*/
function jsonObjTransToUrlparam(param){
    var str="";
    for(var p in param){
        if(param[p]!=null && isJson(param[p])==false){
            str=str+"&"+p+"="+param[p];
        }
    }
    return str.substr(1);
}

function rowisNullClear(row){
	$.each(row, function(name,value) {    
		if(value==null){
			delete row[name];
		}
	});
	console.log(row);
}


/**
 * 张顺，2017-9-15
 * 迭代自pullRequest，是对其的再次封装与补充，用于与公共端普通接口交互
 * @param urlc 真实url后部分
 * @param async 是否异步
 * @param type 请求方式
 * @param jobj 参数
 * @param success 成功时调用的函数,其函数参数为success(data)
 * @param error 失败时执行的函数，注意并不是网络问题导致的失败，是成功接收，只是result=='error'，其函数参数为error(code,data)
 */
function pullRequestCommon(options){
	var obj={},async,success,error;
	if(options){
		obj.url=options.urlc?URL_PATH+options.urlc:"";
		obj.method=options.type?options.type:"POST";
		obj.jobj=options.jobj?options.jobj:{};
		async=typeof(options.async)!="undefined"?options.async:true;
		success=options.success?options.success:function(data){};
		pullRequest({
			urlb:"/itCommon/api/request",
			async:async,
			type:"post",
			data:obj,
			success:success,
			error:error
		});
	}else{
		alert("来自pullRequestCommon的错误提示：参数（options）为空，请检查代码。");
	}
}
/**
 * 张顺，2017-9-19
 * 公共端的文件通用方法，用于文件的上传，比如导入功能
 * @param urlf 真实的url后部分
 * @param fid form表单的id
 * @param success 成功时调用的函数,其函数参数为success(data)
 * @param error 失败时执行的函数，注意并不是网络问题导致的失败，是成功接收，只是result=='error'，其函数参数为error(code,data)
 * @param superSuccess 如果使用这个参数，那么程序将直接以这个覆盖success的回调,并且success将不再生效，superSuccess默认为空
 */
function pullRequestFile(options){
	var urlf,token,fid,success,error,superSuccess;
	if(options){
		urlf=options.urlf?options.urlf:"";
		token=getToken();
		fid=options.fid?options.fid:"";
		success=options.success?options.success:function(data){};
		error=options.error?options.error:null;
		superSuccess=options.superSuccess?options.superSuccess:null;
		var form=new FormData(document.getElementById(fid));
		if(superSuccess){
			if(form){
				form.append("url",URL_PATH+urlf);
				$.ajax({
					url:URL_PATH+"/itCommon/api/request/import",
					type:"POST",
					beforeSend: function (request) {
		    	        request.setRequestHeader("token", getToken());
		    	    },
					data:form,
					cache:false,
					// 告诉jQuery不要去处理发送的数据
					processData:false, 
					// 告诉jQuery不要去设置Content-Type请求头
					contentType:false,
					success:function(data){
						superSuccess(data);
					},
					error:function(XMLHttpRequest, textStatus, errorThrown) {
		        		alert("status:"+XMLHttpRequest.status+"\nreadyState:"+XMLHttpRequest.readyState+"\ntextStatus:"+textStatus);
		    	    }
				});
			}else{
				alert("来自pullRequestFile的错误提示：无法找到id为"+fid+"的元素，请检查参数fid。");
			}
		}else{
			if(form){
				form.append("url",URL_PATH+urlf);
				$.ajax({
					url:URL_PATH+"/itCommon/api/request/import",
					type:"POST",
					beforeSend: function (request) {
		    	        request.setRequestHeader("token", getToken());
		    	    },
					data:form,
					cache:false,
					// 告诉jQuery不要去处理发送的数据
					processData:false, 
					// 告诉jQuery不要去设置Content-Type请求头
					contentType:false,
					success:function(data){
						if(data){
		        			var json;
		        			if(isJson(data)){
		        				json=data;
		        			}else{
		        				json=JSON.parse(data);
		        			}
		        			if(json.result=="success"){
		        				success(json.data);	
		        			}else if(json.result=="error"){
		        				if(error){
		        					error(json.code,json.data);
		        				}else{
		        					alert("错误。\n错误代码："+json.code+"。\n错误参数："+json.data);
		        				}
		        			}
		        		}else{
		        			alert("返回值为空，可能接口出错，请检查后台错误日志。");
		        		}
					},
					error:function(XMLHttpRequest, textStatus, errorThrown) {
		        		alert("status:"+XMLHttpRequest.status+"\nreadyState:"+XMLHttpRequest.readyState+"\ntextStatus:"+textStatus);
		    	    }
				});
			}else{
				alert("来自pullRequestFile的错误提示：无法找到id为"+fid+"的元素，请检查参数fid。");
			}
		}
	}else{
		alert("来自pullRequestFile的错误提示：参数（options）为空，请检查代码。");
	}
}

/**
 * 张顺，2017-9-25，该函数专门处理easyUI数据表格的初始化。
 * **********************************************************************************************************************************
 * 为什么要封装：由于使用了公共接口转发机制，导致不能像原来那样直接写一个url就能获取到数据，现在只能重写获取数据方式，并作一些异常处理，且可达到开发与平常无异的效果，为了让前端人员尽量少写代码以及减少错误率，故将其封装，方便使用。
 * 怎么使用:首先，table不要使用class初始化，且不要设置url和method属性。然后，在html页面中使用$(function(){})调用pullRequestCommonDg进行初始化即可。
 * 需要注意什么：dgid和urlc十分重要。另外，切记，不要使用class初始化，不要设置url和method属性。
 * **********************************************************************************************************************************
 * @param dgid 数据表格的id
 * @param urlc 实际访问的url后半部分
 * @param success 执行成功时的函数，并不是全自定义，本函数已经作了一些预处理，切不可覆盖，success只能在其基础上自定义
 * @param error 执行失败时的函数,同上
 * @param dataf 查询栏位的参数，json对象
 * @returns
 */
function pullRequestCommonDg(options){
	var isGoToOne=false;//是否已经访问的标志
	var dg;
	var dgid,urlc,success,error,dataf;
	dgid=options.dgid?options.dgid:null;
	urlc=options.urlc?options.urlc:null;
	dataf=options.dataf?options.dataf:null;
	if(dgid==null || urlc==null){
		alert("来自pullRequestCommonDg的错误提示。dgid或者urlc为null，请检查参数。");
		return;
	}
	dg=$('#dg');
	if(!dg){
		alert("来自pullRequestCommonDg的错误提示。通过dgid无法找到该元素，请检查是否存在id为"+dgid+"的元素。");
		return;
	}
	success=options.success?options.success:null;
	error=options.error?options.error:null;
	dg.datagrid({
		onBeforeLoad:function(param){
			//console.log(param);
			//将dataf与param合并
			if(dataf!=null){
				if(isJson(dataf)){
					dataf.page=param.page;
					dataf.rows=param.rows;
					dataf.sort=param.sort;
					dataf.order=param.order;
					param=dataf;
				}else{
					alert("来自pullRequestCommonDg的错误提示：dataf不是json对象，请检查参数dataf。");
				}
			}
			if(isGoToOne==false){
				isGoToOne=true;
				dg.datagrid('loading');
				pullRequestCommon({
					urlc:urlc,
					type:"GET",
					jobj:param,
					success:function(data){
						dg.datagrid({
							data:data
						});
						dg.datagrid('loaded');
						isGoToOne=false;
						if(success){
							success(data);
						}
					},
					error:function(code,data){
						alert(code+"  "+data);
						dg.datagrid('loaded');
						isGoToOne=false;
						if(error){
							error(code,data);
						}
					}
				});
			}
			return false;
		}
	});
}

/**
 * 2017-2-21，张顺，这里写一些公共的方法，每个页面都会引用这个js
 */
function getNowTime(fgf){
	var date=new Date();
	var getYear=date.getFullYear();
	var getMonth=date.getMonth()+1;
	if(getMonth<10){
		getMonth="0"+getMonth;
	}
	var getDate=date.getDate();
	var getHours=date.getHours();
	var getMinutes=date.getMinutes();
	var getSeconds=date.getSeconds();
	var times=getYear+fgf+getMonth+fgf+getDate+" "+getHours+":"+getMinutes+":"+getSeconds;
	return times;
}
function getNowDate(fgf){
	var date=new Date();
	var getYear=date.getFullYear();
	var getMonth=date.getMonth()+1;
	if(getMonth<10){
		getMonth="0"+getMonth;
	}
	var getDate=date.getDate();
	var times=getYear+fgf+getMonth+fgf+getDate;
	return times;
}
function displayTime(){
	$("#nowTime").html(getNowTime("-"));
	setTimeout("displayTime()",1000);
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
function search_toolbar(){
	var f=$('#search');
	if(f.form('validate')){
		var json=formToJson(f);
		console.log(json);
		$('#dg').datagrid('load', json);
	}
}
/*张顺，2017-3-11，自定义easyUI的验证框*/
$.extend($.fn.validatebox.defaults.rules, {
    number: {
		validator: function(value,param){
			return !isNaN(value);
		},
		message: '必须为数字.'
    },
    contains: {
		validator: function(value,param){
			return value.indexOf(param[0])>=0;
		},
		message: '必须包含{0}'
    }
});
function isJson(obj){
	var isj = typeof(obj) == "object" && Object.prototype.toString.call(obj).toLowerCase() == "[object object]" && !obj.length; 
	return isj;
}
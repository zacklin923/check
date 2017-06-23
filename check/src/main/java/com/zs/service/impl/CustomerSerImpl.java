package com.zs.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.zs.dao.CheckLogMapper;
import com.zs.dao.CustomerMapper;
import com.zs.entity.CheckLog;
import com.zs.entity.Customer;
import com.zs.entity.CustomerKey;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.CustomerSer;
import com.zs.tools.ExcelExport;
import com.zs.tools.Trans;

@Service("customerSer")
public class CustomerSerImpl implements CustomerSer{

	@Resource
	private CustomerMapper customerMapper;
	@Resource
	private CheckLogMapper logMapper;
	private Logger log=Logger.getLogger(getClass());
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if(accept.getInt1()!=null){
				if(accept.getInt1()!=0){
					accept.setInt1(null);
				}
			}
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=customerMapper.queryFenye(accept);
			int rows=customerMapper.getCount(accept);
			return new EasyUIPage(rows, list);
		}
		return null;
	}
	
	public List<Customer> queryFenye() {
		EasyUIAccept accept = new EasyUIAccept();
		List<Customer> list=customerMapper.queryFenye(accept);
		return list;
	}

	public Integer add(Customer obj) {
		obj.setHistoryCount(new BigDecimal(0));
		return customerMapper.insertSelective(obj);
	}

	public Integer update(Customer obj) {
		return customerMapper.updateByPrimaryKeySelective(obj);
	}
	
	public Integer delete(CustomerKey id) {
		// TODO Auto-generated method stub
		return customerMapper.deleteByPrimaryKey(id);
	}

	public Customer get(CustomerKey id) {
		return customerMapper.selectByPrimaryKey(id);
	}
	
	public String importData(List<String[]> list, String stuNum) {
		Gson g = new Gson();
		List<String> ls = new ArrayList<String>();
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i)[0]!=null&&!list.get(i)[0].trim().equals("")&&list.get(i)[0].trim().length()==6&&isNumeric(Trans.tostring(list.get(i)[0]))==true){
					CustomerKey ck = new CustomerKey();
					ck.setCteBarCode(list.get(i)[0]);
					ck.setHistoryCount(new BigDecimal(0));
					Customer isct =  get(ck);
					try {
						Customer code=new Customer(list.get(i)[1],list.get(i)[2],list.get(i)[3],list.get(i)[4],
								list.get(i)[5],list.get(i)[6],list.get(i)[7],list.get(i)[8],Trans.TransToDate(list.get(i)[9]),
								Trans.TransToDate(list.get(i)[10]),list.get(i)[11],list.get(i)[12],list.get(i)[13],
								Trans.toBigDecimal(list.get(i)[14]),list.get(i)[15],list.get(i)[16],list.get(i)[17],
								list.get(i)[18],list.get(i)[19],list.get(i)[20],list.get(i)[21],list.get(i)[22],
								list.get(i)[23],"启用",new Timestamp(new Date().getTime()));
						code.setCteBarCode(list.get(i)[0]);
						code.setHistoryCount(new BigDecimal(0));
						if(isct==null){
							CheckLog cLog = new CheckLog(null,list.get(i)[0] ,null,"customer",g.toJson(code) ,null, stuNum,"添加");
							logMapper.insertSelective(cLog);
							customerMapper.insertSelective(code);
						}else{
							CheckLog cLog = new CheckLog(null,list.get(i)[0] ,null,"customer",g.toJson(isct) ,null, stuNum,"修改");
							logMapper.insertSelective(cLog);
							customerMapper.updateByPrimaryKeySelective(code);
						}
					} catch (Exception e) {
						e.printStackTrace();
						ls.add((i+1)+"");
					}
				
			}else{
				ls.add((i+1)+"");
			}
		}
		if(ls.size()>0){
			return "数据导入错误行号为"+new Gson().toJson(ls);
		}else{
			return "";
		}
	}

	//用JAVA自带的函数判断是否是纯数字
	private boolean isNumeric(String str){
		for (int i = 0; i < str.length(); i++){
		   if (!Character.isDigit(str.charAt(i))){
			   return false;
		   }
		}
		return true;
	}

	public String exportData(EasyUIAccept accept, HttpServletRequest request) {
		if(accept.getInt1()!=null){
			if(accept.getInt1()!=0){
				accept.setInt1(null);
			}
		}
		List<Customer> list=customerMapper.queryFenye(accept);
		String[] obj ={"客户条码","客户名称","维护客户（中端）","维护客服（前端）","维护客服（后端）","客户类型","大区","区部","分部","开通时间",
				"暂停时间","业务负责人","结算方式","面单类型","日均发货量","寄递货物详情","提货方式","集包点","退件","物料","投诉返利",
				"操作罚款","费用理赔","备注","启用状态"};
		String[][] objs = new String[list.size()][obj.length];
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < objs.length; i++) {
			Customer customer=list.get(i);
			objs[i][0] = customer.getCteBarCode();
			objs[i][1] = customer.getCteName();
			objs[i][2] = customer.getCustomServiceCenter();
			objs[i][3] = customer.getCustomServiceTop();
			objs[i][4] = customer.getCustomServiceLast();
			objs[i][5] = customer.getCustomType();
			objs[i][6] = customer.getLargeArea();
			objs[i][7] = customer.getSliceArea();
			objs[i][8] = customer.getFenbu();
			objs[i][9] = customer.getOpenDate()==null?"":sdf.format(customer.getOpenDate());
			objs[i][10] = customer.getOutDate()==null?"":sdf.format(customer.getOutDate());
			objs[i][11] = customer.getBusiness();
			objs[i][12] = customer.getAccountsType();
			objs[i][13] = customer.getPageType();
			objs[i][14] = customer.getDailyDelivery()==null?"":customer.getDailyDelivery().toString();
			objs[i][15] = customer.getGoodsDetail();
			objs[i][16] = customer.getCarryGoodsType();
			objs[i][17] = customer.getPacketPoint();
			objs[i][18] = customer.getReturnPiece();
			objs[i][19] = customer.getMatter();
			objs[i][20] = customer.getComplainRebate();
			objs[i][21] = customer.getOptionFine();
			objs[i][22] = customer.getFeeCompensate();
			objs[i][23] = customer.getNote();
			objs[i][24] = customer.getState();
		}
		String basePath = request.getSession().getServletContext().getRealPath("/");
		String path ="file/大客户信息.xls";
		ExcelExport.OutExcel1(obj, objs, basePath+path);
		return path;
	}

	

}

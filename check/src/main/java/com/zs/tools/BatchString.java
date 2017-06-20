package com.zs.tools;

import org.apache.log4j.Logger;

public class BatchString {

	public static String batchstr(String str1){
		Logger log = Logger.getLogger(BatchString.class);
		if(str1!=null&&!str1.equals("")){
			String [] ss = str1.trim().split(",");
			String str="";
			for (int i = 0; i < ss.length; i++) {
				String strt=ss[i].trim();
				if(!strt.equals("")&&strt!=null){
					if(i!=ss.length-1){
						str=str+"'"+strt+"'"+",";
					}else{
						str=str+"'"+strt+"'";
					}
				}
			}
			if(str!=null&&!str.equals(",")){
				return str;
			}
		}
		log.error("批量查询字符串转换失败，失败字符串为"+str1);
		return null;
	}
}

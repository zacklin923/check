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
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	
	public static String oldbatchstr(String str){
		Logger log = Logger.getLogger(BatchString.class);
		if(str!=null&&!str.equals("")){
			String st = str.replace("\r\n", ",");
			String [] ss = st.trim().split(",");
			String retstr="";
			for (int i = 0; i < ss.length; i++) {
				String strt=ss[i].trim();
				if(!strt.equals("")&&strt!=null){
					if(i!=ss.length-1){
						retstr=retstr+"'"+strt+"'"+",";
					}else{
						retstr=retstr+"'"+strt+"'";
					}
				}
			}
			if(retstr!=null&&!retstr.equals(",")){
				return retstr;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
}

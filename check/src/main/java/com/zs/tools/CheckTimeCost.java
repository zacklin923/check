package com.zs.tools;

import org.apache.log4j.Logger;

/**
 * 方法耗时检查工具
 * @author 张顺，2017-6-28
 */
public class CheckTimeCost {

	private long t1=0;
	private static CheckTimeCost timeCost=new CheckTimeCost();
	
	
	public long getT1() {
		return t1;
	}
	public void setT1(long t1) {
		this.t1 = t1;
	}

	public static void tellTimeCost(String text){
		if (timeCost.getT1()==0) {
			timeCost.setT1(System.currentTimeMillis());
		}
		long t2=System.currentTimeMillis();
		System.out.println(("[耗时]["+(text==null?"":text)+"]"+(t2-timeCost.getT1())));
		timeCost.setT1(t2);
	}
	
	public static CheckTimeCost initT1(){
		timeCost.setT1(0);
		return timeCost;
	}
	
}

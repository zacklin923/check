package com.zs.tools;

/**
 * url的预处理
 * 灵感来源于sql的预处理，
 * 用于权限拦截器
 * @author 张顺 2017-5-11
 */
public class RestUrlPrepared {

	/**
	 * 主要处理权限url的"?"的符号
	 * @param targetUrl
	 * @param roleUrl
	 * @return
	 */
	public static boolean isEqualsByPrepared(String targetUrl,String roleUrl) {
		String tar[]=targetUrl.split("/");
		String rol[]=roleUrl.split("/");
		for (int i = 0; i < tar.length; i++) {
			String ro="";
			try {
				ro=rol[i];
			} catch (Exception e) {
				return false;
			}
			if (tar[i].equals(ro) || ro.equals("?")) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
	
}

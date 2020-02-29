package cn.com.yusys.file.util;

import java.util.UUID;


/**
 * @author Administrator
 *
 */
public class Constants {
	/**
	 * 法规政策分类一级，编码，外规
	 */
	public static final String TYPETREECODE_W = "00001";
	/**
	 * 法规政策分类一级，名称，外规
	 */
	public static final String TYPETREECODE_W_CN = "外规";
	/**
	 * 法规政策分类一级，编码，内规
	 */
	public static final String TYPETREECODE_N = "00002";
	/**
	 * 法规政策分类一级，名称，内规
	 */
	public static final String TYPETREECODE_N_CN = "内规";
	
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		String result = uuid.toString().replace("-", "");
		return result;
	}
	
	public static void main(String[] args) {
		String result = getUUID();
	    System.out.println(result);
	    System.out.println(result.length());
    }
}

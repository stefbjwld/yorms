package cn.com.yusys.file.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TimesUtil {
	
	public static final String FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static Date timestamp2Date(Timestamp t){
		Date date = new Date(t.getTime());
		return date;
	}
	
	/**
	 * 获取当前时间的字符串格式
	 * @return
	 */
	public static String getCurrentTime(){
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
		return sdf.format(new Date());
	}
}

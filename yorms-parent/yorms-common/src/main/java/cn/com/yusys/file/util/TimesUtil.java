package cn.com.yusys.file.util;

import java.sql.Timestamp;
import java.util.Date;


public class TimesUtil {
	
	public static Date timestamp2Date(Timestamp t){
		Date date = new Date(t.getTime());
		return date;
	}
}

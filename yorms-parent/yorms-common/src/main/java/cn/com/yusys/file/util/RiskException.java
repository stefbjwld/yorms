package cn.com.yusys.file.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * risk工程异常工具类
 * @author Administrator
 *
 */
public class RiskException extends Exception{

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(RiskException.class);
	
	public RiskException(String message) {
		super(message);
	}
	
	public RiskException(String message, Exception exception) {
		this(message + exception.getMessage());
		log.error(message, exception);
	}
}

package cn.com.yusys.activiti.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	private static final Logger log = LoggerFactory.getLogger(TestService.class);
	
	public void activiti(){
		log.info("任务已经执行...");
	}
	
	public List<String> user(){
		return Arrays.asList("xiaoming","xiaohong");
	}
}

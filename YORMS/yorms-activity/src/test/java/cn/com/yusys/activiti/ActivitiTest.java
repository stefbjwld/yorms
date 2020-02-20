package cn.com.yusys.activiti;

import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.yusys.activiti.ActivitiApplication;
import cn.com.yusys.activiti.service.TestService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ActivitiApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ActivitiTest {
	
	private static final Logger log = LoggerFactory.getLogger(ActivitiTest.class);
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Test
	public void testStartProcess(){
		log.info("start ...");
//		ProcessInstance pi = runtimeService.startProcessInstanceById("MyProcesses","1");
		ProcessInstance pi = runtimeService.startProcessInstanceByKey("myProcess","1");
		log.info("流程启动成功,流程id:"+pi.getId());
	}
	
	@Test
    public void findTasksByUserId() {
        String userId ="dulingjiang";
        List<Task> resultTask = taskService.createTaskQuery().processDefinitionKey("myProcess").taskCandidateOrAssigned(userId).list();
        System.out.println("任务列表："+resultTask);
    }
}

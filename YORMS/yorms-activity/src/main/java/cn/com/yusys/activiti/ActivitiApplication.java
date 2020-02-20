package cn.com.yusys.activiti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * eureka server
 */
@SpringBootApplication(exclude={org.activiti.spring.boot.SecurityAutoConfiguration.class})
@EnableDiscoveryClient
@ComponentScan(value = {"cn.com.yusys.activiti"})
public class ActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivitiApplication.class, args);
    }
}
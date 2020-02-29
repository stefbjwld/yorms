package cn.com.yusys.file.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.com.yusys.file.service.HdfsService;

@Configuration
public class HdfsConfig {
    private String defaultHdfsUri = "hdfs://127.0.0.1:9000";

    @Bean
    public HdfsService getHbaseService(){
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        conf.set("fs.defaultFS",defaultHdfsUri);
        return new HdfsService(conf,defaultHdfsUri);
    }
}

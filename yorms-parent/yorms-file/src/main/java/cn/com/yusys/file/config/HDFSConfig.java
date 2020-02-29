package cn.com.yusys.file.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.com.yusys.file.util.HDFSUtil;

@Configuration
public class HDFSConfig {
	
	private String defaultHdfsUri = "hdfs://172.25.0.2:50070"; // hdfs://172.25.0.2:50070

    @Bean
    public HDFSUtil getHbaseService(){
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        conf.set("fs.defaultFS",defaultHdfsUri);
        return new HDFSUtil(conf,defaultHdfsUri);
    }
}

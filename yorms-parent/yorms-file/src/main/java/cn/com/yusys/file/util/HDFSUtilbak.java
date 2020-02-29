package cn.com.yusys.file.util;
//package cn.com.yusys.file.util;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.URI;
//
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.fs.FSDataInputStream;
//import org.apache.hadoop.fs.FileSystem;
//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.IOUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
///**
// * HDFS操作工具类
// * @author Administrator
// *
// */
//@Component
//public class HDFSUtil {
//	
//	public HDFSUtil hdfsUtil = null;
//	
//	public HDFSUtil getInstance(){
//		if(hdfsUtil == null){
//			hdfsUtil = new HDFSUtil();
//		}
//		return hdfsUtil;
//	}
//	
//	public HDFSUtil(){
//		try {
//	        throw new Exception("create constructors method fail !");
//        } catch (Exception e) {
//	        e.printStackTrace();
//        }
//	}
//	
//	private static final Logger log = LoggerFactory.getLogger(HDFSUtil.class);
//	public static final String CROSS_PLATFORM =  "mapreduce.app-submission.cross-platform";
//	public static final String FS_HDFS_IMPL_PARAM = "fs.hdfs.impl";
//	public static final String FS_HDFS_IMPL = "org.apache.hadoop.hdfs.DistributedFileSystem";
//	
//	private String defaultFs;
//	private String hdfsname;
//	private String nameservices;
//	private String ha_namenodes_ns1;
//	private String nameonode_rpc_address_ns1_nn1;
//	private String client_failover_proxy_provider_ns1;
//	private String hadoop_tmp_dir;
//	
//    public String getDefaultFs() {
//    	return defaultFs;
//    }
//	
//    public void setDefaultFs(String defaultFs) {
//    	this.defaultFs = defaultFs;
//    }
//	
//    public String getHdfsname() {
//    	return hdfsname;
//    }
//	
//    public void setHdfsname(String hdfsname) {
//    	this.hdfsname = hdfsname;
//    }
//	
//    public String getNameservices() {
//    	return nameservices;
//    }
//	
//    public void setNameservices(String nameservices) {
//    	this.nameservices = nameservices;
//    }
//	
//    public String getHa_namenodes_ns1() {
//    	return ha_namenodes_ns1;
//    }
//	
//    public void setHa_namenodes_ns1(String ha_namenodes_ns1) {
//    	this.ha_namenodes_ns1 = ha_namenodes_ns1;
//    }
//	
//    public String getNameonode_rpc_address_ns1_nn1() {
//    	return nameonode_rpc_address_ns1_nn1;
//    }
//	
//    public void setNameonode_rpc_address_ns1_nn1(String nameonode_rpc_address_ns1_nn1) {
//    	this.nameonode_rpc_address_ns1_nn1 = nameonode_rpc_address_ns1_nn1;
//    }
//	
//    public String getClient_failover_proxy_provider_ns1() {
//    	return client_failover_proxy_provider_ns1;
//    }
//	
//    public void setClient_failover_proxy_provider_ns1(String client_failover_proxy_provider_ns1) {
//    	this.client_failover_proxy_provider_ns1 = client_failover_proxy_provider_ns1;
//    }
//	
//    public String getHadoop_tmp_dir() {
//    	return hadoop_tmp_dir;
//    }
//	
//    public void setHadoop_tmp_dir(String hadoop_tmp_dir) {
//    	this.hadoop_tmp_dir = hadoop_tmp_dir;
//    }
//	
//    /**
//     * 获取配置信息
//     * @return
//     */
//	public Configuration getConfiguration(){
//		Configuration configuration = new Configuration();
//		configuration.set("fs.defaultFS", defaultFs);
//		configuration.set("dfs.nameservices",nameservices);
//		configuration.set("dfs.ha.namenodes."+nameservices, ha_namenodes_ns1);
//		String[] nn1s = nameonode_rpc_address_ns1_nn1.split(",");
//		for(int i =0 ;i< nn1s.length;i++){
//			log.info("nn1s的长度是：{}",nn1s[i].substring(0,3),nn1s[i].substring(4));
//			configuration.set("dfs.namenode.rpc-address."+nameservices+"."+nn1s[i].substring(0,3), nn1s[i].substring(4));
//		}
//		configuration.set("dfs.client.failover.proxy.provider."+nameservices, client_failover_proxy_provider_ns1);
//		configuration.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
//		configuration.set("dfs.client.block.write.replace-datanode-on-failure.policy", "NEVER");
//		return configuration;
//	}
//
//	/**
//	 * 文件上传服务
//	 * @param srcPath	源文件
//	 * @param dstPath	目标路径
//	 * @param hdfsUrl	hdfsUrl
//	 * @param user		上传用户
//	 * @throws Exception
//	 */
//	public void uploadHDFS(String srcPath,String dstPath,String hdfsUrl,String user)throws Exception{
//		Configuration conf = getConfiguration();
//		conf.set("fs.defaultFS", hdfsUrl);
//		conf.set(HDFSUtil.FS_HDFS_IMPL_PARAM, HDFSUtil.FS_HDFS_IMPL);
//		FileSystem fs;
//		try{
//			fs = FileSystem.get(new URI(hdfsUrl),conf,user);
//			Path src = new Path(srcPath);
//			Path dst = new Path(dstPath);
//			fs.copyFromLocalFile(src, dst);
//			fs.close();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * HDFS文件下载
//	 * @param hadoopHome
//	 * @param hdfsUrl
//	 * @param localFName
//	 * @param hdfsName
//	 * @param user
//	 * @throws Exception
//	 */
//	@SuppressWarnings("static-access")
//    public void downFlieFromHDFS(String hadoopHome,String hdfsUrl,String localFName,String hdfsName,String user)throws Exception{
//		Configuration conf = getConfiguration();
//		conf.set("fs.defaultFS", hdfsUrl);
//		conf.set(HDFSUtil.FS_HDFS_IMPL_PARAM, HDFSUtil.FS_HDFS_IMPL);
//		conf.set("hadoop.home.dir", hadoopHome);
//		String hdfsPath = hdfsUrl + hdfsName;
//		FileSystem fs = null;
//		FSDataInputStream outHDFS = null;
//		OutputStream inLocal = null;
//		try{
//			fs = FileSystem.get(new URI(hdfsUrl).create(hdfsPath),conf);//创建文件夹对象
//			outHDFS = fs.open(new Path(hdfsPath));//从HDFS读出文件流
//			inLocal = new FileOutputStream(localFName);//写入本地文件
//			IOUtils.copyBytes(outHDFS, inLocal, 1024*1024*10,true);
//			fs.close();
//			outHDFS.close();
//			inLocal.close();
//		}catch(IOException e){
//			log.info("");
//		}finally{
//			if(fs!=null){
//				fs.close();
//			}
//			if(outHDFS!=null){
//				outHDFS.close();
//			}
//			if(inLocal!=null){
//				inLocal.close();
//			}
//		}
//		
//	}
//	
//	public void mkdir(String hadoopHome,String hdfsUrl,String user,String path)throws Exception{
//		Configuration conf = getConfiguration();
//		conf.set(HDFSUtil.FS_HDFS_IMPL_PARAM, HDFSUtil.FS_HDFS_IMPL);
//		conf.set("dfs.client.block.write.replatce-datanode-on-failure.policy", "NEVER");
//		FileSystem fs = null;
//		try{
//			fs = FileSystem.get(new URI(hdfsUrl,conf,user));
//		}
//	}
//}
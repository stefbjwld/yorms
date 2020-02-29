package cn.com.yusys.file.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.com.yusys.file.service.HdfsService;

@RestController("/hdfs")
@Api(value = "/hdfs",description = "附件上传HDFS")
public class HDFSUploadController {
	
	@Autowired
	private HdfsService hdfsService;
	 /**
     * 实现文件上传
	 * @throws IOException 
     * */
    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
    @ResponseBody 
    @ApiOperation(value = "/fileUpload",notes = "文件上传")
    public String fileUpload(@RequestParam("fileName") MultipartFile file) throws IOException{
    	System.out.println("upload");
        InputStream in = file.getInputStream();
        String oriName = file.getOriginalFilename();
        //建立临时文件
//        File tmpFile = new File(this.getClass().getResource("/").getPath() + File.separator+oriName);
        File tmpFile = new File(System.getProperty("user.dir")+File.separator+oriName);
        if(!tmpFile.exists()){
        	tmpFile.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(tmpFile);
        byte[] b = new byte[1024];
        int length;
        while((length = in.read(b))!= -1){
        	fos.write(b,0,length);
        }
        System.out.println(oriName);
        //上传路径
        String cloudPath = "/meisw/hdfs/" + file.getOriginalFilename();
//        hdfsClient.upload1(in, cloudPath);
        hdfsService.uploadFileToHdfs(tmpFile.getPath(), cloudPath);
//        in.close();
        fos.close();
        in.close();
        tmpFile.delete();
        return "uploads ok";
    }
}

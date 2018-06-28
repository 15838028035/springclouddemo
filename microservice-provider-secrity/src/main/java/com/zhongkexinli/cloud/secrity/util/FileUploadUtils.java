package com.zhongkexinli.cloud.secrity.util;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

/**
 * Created by dongxc on 2015/7/20. 文件上传
 */
public class FileUploadUtils {

    private static Logger log             = LoggerFactory.getLogger(FileUploadUtils.class);
    public static String  accessKeyId     = "6MqJQ1afWMwdt82V";                            // "6Horvio4CguKwkTQ";
                                                                                            // "6MqJQ1afWMwdt82V"; 信融
    public static String  accessKeySecret = "aalHStrgkbXhMvIXC96RGPRbJiavWN";              // "Y1ACw5BI1WRjiWd8G0OupsQJmpf61z";
                                                                                            // aalHStrgkbXhMvIXC96RGPRbJiavWN;信融
    public static String  endpoint        = "http://oss-cn-shanghai.aliyuncs.com";         // "http://oss-cn-hangzhou.aliyuncs.com";

    // public static String bucketName = "weidaiosstest";

    public static void uploadPicture(MultipartFile mf, String bucketName, String key) throws Exception {
        try {
            // 初始化一个OSSClient
            OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            InputStream content = mf.getInputStream();
            // 创建上传Object的Metadata
            ObjectMetadata meta = new ObjectMetadata();
            // 必须设置ContentLength
            // meta.setExpirationTime(expirationTime);
            meta.setContentLength(mf.getBytes().length);
            // 上传Object.
            PutObjectResult result = client.putObject(bucketName, key, content, meta);

            if (result != null) {
                log.info("文件上传" + result.getETag());
            }
        } catch (Exception e) {
            log.error("文件上传失败[FileUploadUtils]", e);
            throw new Exception(e.getMessage(), e);
        }
    }

}

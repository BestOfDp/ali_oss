package cn.lsu.chicken.file.util;


import cn.lsu.chicken.file.constants.AliyunOSSConfigConstant;
import cn.lsu.chicken.file.enums.OSSTypeEnum;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class AliyunOSSUtil {

    private static String bucketName = AliyunOSSConfigConstant.BUCKE_NAME;
    private static String endpoint = AliyunOSSConfigConstant.END_POINT;
    private static String accessKeyId = AliyunOSSConfigConstant.AccessKey_ID;
    private static String accessKeySecret = AliyunOSSConfigConstant.AccessKey_Secret;
    private static String prefix = "http://ajinfile.oss-cn-hangzhou.aliyuncs.com/";

    public static String upload(InputStream file, String name, Integer type) {
        if (file == null) {
            throw new RuntimeException("文件不能为空");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = dateFormat.format(new Date()) + "/";
        String filename = OSSTypeEnum.getNameByCode(type) + dateStr +
                UUID.randomUUID().toString() + FilenameUtil.getSuffix(name);
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        ossClient.putObject(bucketName, filename, file);
        ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
        ossClient.shutdown();
        return prefix + filename;
    }
}

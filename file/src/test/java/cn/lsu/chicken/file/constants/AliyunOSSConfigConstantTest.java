package cn.lsu.chicken.file.constants;

import cn.lsu.chicken.file.util.AliyunOSSUtil;
import com.aliyun.oss.OSSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AliyunOSSConfigConstantTest {

    @Test
    public void save() {
        String bucketName = AliyunOSSConfigConstant.BUCKE_NAME;
        String endpoint = AliyunOSSConfigConstant.END_POINT;
        String accessKeyId = AliyunOSSConfigConstant.AccessKey_ID;
        String accessKeySecret = AliyunOSSConfigConstant.AccessKey_Secret;

        String path = "E:\\Java\\spingboot\\file\\src\\main\\java\\cn\\lsu\\chicken\\file\\constants\\AliyunOSSConfigConstant.java";
        File file = new File(path);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, "111.java", inputStream);
        ossClient.shutdown();
    }

    @Test
    public void upload() {
//        String path = "C:\\Users\\InTheBloodHorse\\Desktop\\1.jpg";
//        File file = new File(path);
//        String result = AliyunOSSUtil.upload(file,0);
//        System.out.println(result);
    }
}
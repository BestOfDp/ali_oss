package cn.lsu.chicken.file.face;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.arcsoft.face.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FaceTest {


    @Test
    public void dotest() {
        String appId = "EzU1ASsWJZVnAtwVGENdUfhgozqm32is8AtaW6rUoPyH";
        String sdkkey = "Ehg4vSRg2cmohEEN4sPCZjCHGZdxhHBVSCfS3E86jKmd";
        FaceEngine faceEngine = new FaceEngine();
        faceEngine.active(appId, sdkkey);

        FaceFeature faceFeature = new FaceFeature();

        System.out.println(111);

    }
}

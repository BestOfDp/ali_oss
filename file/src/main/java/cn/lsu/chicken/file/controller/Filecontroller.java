package cn.lsu.chicken.file.controller;

import cn.lsu.chicken.file.util.AliyunOSSUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/oss")
public class Filecontroller {

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        String url = null;
        try {
            url = AliyunOSSUtil.upload(file.getInputStream(), file.getOriginalFilename(), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }
}

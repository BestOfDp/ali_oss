package cn.lsu.chicken.file.controller;

import cn.lsu.chicken.file.util.AliyunOSSUtil;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebResult;
import java.beans.PropertyEditorSupport;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/oss")
public class FileController {

    @PostMapping("/upload")
    public String upload(@RequestParam("type") String type,
                         @RequestParam("file") MultipartFile file) {
        return AliyunOSSUtil.upload(file, Integer.valueOf(type));
    }

    @PostMapping("/delete")
    public Integer delete(@RequestParam("url") String url) {
        AliyunOSSUtil.delete(url);
        return 1;
    }
}

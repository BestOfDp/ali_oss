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
public class Filecontroller {

    @PostMapping("/upload")
    public String upload(@RequestParam("type") Integer type,
                         @RequestParam("file") InputStream file,
                         @RequestParam("fileName") String fileName) {
        return AliyunOSSUtil.upload(file, fileName, type);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(InputStream.class, new MyInputStream());
    }

    private class MyInputStream extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            InputStream inputStream = new ByteArrayInputStream(text.getBytes());
            setValue(inputStream);
        }
    }
}

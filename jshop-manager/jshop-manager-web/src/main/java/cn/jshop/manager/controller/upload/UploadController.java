package cn.jshop.manager.controller.upload;

import cn.jshop.manager.service.upload.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by 郭旭辉 on 2016/11/22.
 */
@Controller
@RequestMapping(value="/upload")
public class UploadController {

    @Autowired
    private IUploadService uploadService;

    @ResponseBody
    @RequestMapping(value = "/img")
    public String uploadImages(MultipartFile file) throws IOException {
            return uploadService.uploadImg(file);
    }
}

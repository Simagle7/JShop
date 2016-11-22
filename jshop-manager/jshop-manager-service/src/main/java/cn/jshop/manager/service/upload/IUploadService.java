package cn.jshop.manager.service.upload;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by 郭旭辉 on 2016/11/22.
 * 上传接口
 */

public interface IUploadService {

    /**
     * 上传图片
     * @param file
     * @return
     */
    String uploadImg(MultipartFile file) throws IOException;
}

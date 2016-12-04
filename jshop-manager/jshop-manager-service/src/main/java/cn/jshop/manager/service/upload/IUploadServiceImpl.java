package cn.jshop.manager.service.upload;

import cn.jshop.common.exception.BizException;
import cn.jshop.common.utils.CommonUtils;
import cn.jshop.common.utils.DataStatusEnum;
import cn.jshop.common.utils.ERRORCODE;
import cn.jshop.common.utils.ftp.FtpUtils;
import cn.jshop.manager.dao.base.IFtpFileDAO;
import cn.jshop.manager.domain.base.FtpFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * Created by 郭旭辉 on 2016/11/22.
 * 上传接口实现类
 */
@Service("IUploadServiceImpl")
public class IUploadServiceImpl implements IUploadService {

    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private int FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_URL}")
    private String FTP_BASE_URL;
    @Value("${IMG_BASE_PATH}")
    private String IMG_BASE_PATH;

    @Autowired
    private IFtpFileDAO ftpFileDAO;

    @Override
    public String uploadImg(MultipartFile file) throws IOException {
        //生成一个新的文件名，取原始文件名
        String oldName = file.getOriginalFilename();

        //生成新的文件名
        String newName = CommonUtils.genImageName();
        newName += oldName.substring(oldName.lastIndexOf("."));
        String filePath = "/" + CommonUtils.datetoString(new Date(), "yyyy/MM/dd");
        boolean flag = FtpUtils.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_URL, filePath, newName, file.getInputStream());
        if (flag) {
            FtpFile ftpFile = new FtpFile();
            ftpFile.setRemotePath(FTP_BASE_URL);
            ftpFile.setFilePath(filePath);
            ftpFile.setFileName(newName);
            ftpFile.setStatus(DataStatusEnum.DISABLED.getValue());
            ftpFileDAO.insert(ftpFile);
            return IMG_BASE_PATH + filePath + "/" + newName;
        }
        throw new BizException(ERRORCODE.UPLOAD_IMG_ERROR.getCode(), ERRORCODE.UPLOAD_IMG_ERROR.getMessage());
    }
}

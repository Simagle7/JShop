/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：ftp文件状态											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-12-03  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.jshop.manager.service.base;

import cn.jshop.manager.dao.IJShopBaseDAO;
import cn.jshop.manager.dao.base.IFtpFileDAO;
import cn.jshop.manager.domain.base.FtpFile;
import cn.jshop.manager.service.AbstractJShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 /**
 * 《ftp文件状态》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("FtpFileServiceImpl")
public class FtpFileServiceImpl extends AbstractJShopService<IJShopBaseDAO<FtpFile>, FtpFile> implements IFtpFileService<IJShopBaseDAO<FtpFile>,FtpFile>{
    @Autowired
    private IFtpFileDAO ftpFileDAO;

    @Override
    public IJShopBaseDAO<FtpFile> getDao() {
        return ftpFileDAO;
    }

}
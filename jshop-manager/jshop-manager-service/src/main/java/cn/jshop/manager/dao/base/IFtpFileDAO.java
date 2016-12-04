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

package cn.jshop.manager.dao.base;

import cn.jshop.manager.dao.IJShopBaseDAO;
import cn.jshop.manager.domain.base.FtpFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 《ftp文件状态》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IFtpFileDAO extends IJShopBaseDAO<FtpFile> {

    /**
     * 批量更新照片状态
     * @param imgNames    图片名称列表
     * @param status      图片状态，0：正常，1审核
     * @return 返回，0：失败，1：更新的条数
     */
   int updateStatus(@Param("list") List<String> imgNames, @Param("status") Integer status);
}
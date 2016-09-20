/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-09-20  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.jshop.ssm.service.tb;

import cn.jshop.common.domain.BaseDomain;
import cn.jshop.ssm.dao.IJShopBaseDAO;
import cn.jshop.ssm.domain.tb.EasyUIResult;
import cn.jshop.ssm.service.IJShopBaseService;

/**
 * 《用户表》 业务逻辑服务接口
 * @author 郭旭辉
 *
 */
public interface IUserService<D extends IJShopBaseDAO<T>, T extends BaseDomain> extends IJShopBaseService<D, T>{

    EasyUIResult queryUserList(Integer page, Integer rows);
}
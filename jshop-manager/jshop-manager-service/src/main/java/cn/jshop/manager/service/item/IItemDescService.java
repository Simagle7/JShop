/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  simagle
{  审查人：
{  模块：商品描述表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-10-23  simagle        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.jshop.manager.service.item;

import cn.jshop.common.domain.BaseDomain;
import cn.jshop.manager.dao.IJShopBaseDAO;
import cn.jshop.manager.service.IJShopBaseService;

 /**
 * 《商品描述》 业务逻辑服务接口
 * @author simagle
 *
 */
public interface IItemDescService<D extends IJShopBaseDAO<T>, T extends BaseDomain> extends IJShopBaseService<D, T>{

}
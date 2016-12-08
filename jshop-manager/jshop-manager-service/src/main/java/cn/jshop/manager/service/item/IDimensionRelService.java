/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：商品规格和商品的关系表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-12-07  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.jshop.manager.service.item;

import cn.jshop.common.domain.BaseDomain;
import cn.jshop.manager.dao.IJShopBaseDAO;
import cn.jshop.manager.service.IJShopBaseService;
import org.springframework.web.servlet.ModelAndView;

/**
 * 《商品规格和商品的关系》 业务逻辑服务接口
 * @author 郭旭辉
 *
 */
public interface IDimensionRelService<D extends IJShopBaseDAO<T>, T extends BaseDomain> extends IJShopBaseService<D, T>{

    /**
     * 商品规格参数弹框
     * @param itemId    商品id
     * @return  返回，视图与数据
     */
     ModelAndView loadDimension(long itemId);
 }
/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：商品规则参数											
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

import cn.jshop.common.domain.AccountDto;
import cn.jshop.common.domain.BaseDomain;
import cn.jshop.manager.dao.IJShopBaseDAO;
import cn.jshop.manager.param.item.DimensionParam;
import cn.jshop.manager.service.IJShopBaseService;
import org.springframework.web.servlet.ModelAndView;

/**
 * 《商品规则参数》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IDimensionService<D extends IJShopBaseDAO<T>, T extends BaseDomain> extends IJShopBaseService<D, T> {

    /**
     * 分页查询
     * @param param
     * @param pageNo
     * @param pageSize
     * @return
     */
    ModelAndView queryPage(DimensionParam param, Integer pageNo, Integer pageSize);

    /**
     * 保存一条商品规格参数模板
     * @param param             待保存的规格模板参数
     * @param currentUser       当前操作者
     * @return  返回，操作码
     */
    String saveDimension(DimensionParam param, AccountDto currentUser);


}
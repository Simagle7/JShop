/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：商品表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-10-20  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.jshop.manager.service.item;

import cn.jshop.common.domain.AccountDto;
import cn.jshop.common.domain.BaseDomain;
import cn.jshop.manager.dao.IJShopBaseDAO;
import cn.jshop.manager.param.item.ItemParam;
import cn.jshop.manager.param.item.ItemParamEx;
import cn.jshop.manager.service.IJShopBaseService;
import org.springframework.web.servlet.ModelAndView;

/**
 * 《商品》 业务逻辑服务接口
 *
 * @author simagle
 */
public interface IItemService<D extends IJShopBaseDAO<T>, T extends BaseDomain> extends IJShopBaseService<D, T> {


    /**
     * 添加一个商品
     * @param paramEx         商品参数
     * @param accountDto        当前操作用户
     * @return  返回，视图模型
     */
    String saveItem(ItemParamEx paramEx, AccountDto accountDto);

    /**
     *  分页查询
     * @param param     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return  返回，视图与数据
     */
    ModelAndView queryPage(ItemParam param,Integer pageNo, Integer pageSize);

    /**
     * 更新商品视图弹窗（数据回显）
     * @param id       商品id
     * @return   返回，视图与数据
     */
    ModelAndView update(long id);
}
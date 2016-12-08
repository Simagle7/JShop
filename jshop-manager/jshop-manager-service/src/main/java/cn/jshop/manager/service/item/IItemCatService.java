/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：商品类目											
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

import cn.jshop.common.domain.BaseDomain;
import cn.jshop.common.domain.TreeNode;
import cn.jshop.manager.dao.IJShopBaseDAO;
import cn.jshop.manager.service.IJShopBaseService;

import java.util.List;

/**
 * 《商品类目》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IItemCatService<D extends IJShopBaseDAO<T>, T extends BaseDomain> extends IJShopBaseService<D, T> {

    /**
     * 根据父节点获取子节点
     * @param pId   父节点，0：根节点
     * @param allIn 全部节点，true：是，false：否
     * @return  返回，子节点列表
     */
    List<TreeNode> getChildCat(int pId, Boolean allIn);



}
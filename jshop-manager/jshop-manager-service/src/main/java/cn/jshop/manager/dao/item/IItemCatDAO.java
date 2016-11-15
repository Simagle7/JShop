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

package cn.jshop.manager.dao.item;

import cn.jshop.common.domain.TreeNode;
import cn.jshop.manager.dao.IJShopBaseDAO;
import cn.jshop.manager.domain.item.ItemCat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 《商品类目》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IItemCatDAO extends IJShopBaseDAO<ItemCat> {


    /**
     * 获取字节点
     * @param pId       父节点id
     * @param status    状态，可选值:1(正常),2(软删除)
     * @return  返回，子节点列表
     */
    List<TreeNode> getChildCat(@Param("pId") Integer pId, @Param("status") Integer status);
}
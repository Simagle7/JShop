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

package cn.jshop.manager.dao.item;

import cn.jshop.manager.dao.IJShopBaseDAO;
import cn.jshop.manager.domain.item.Item;
import cn.jshop.manager.domain.item.ItemEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《商品》 数据访问接口
 * @author 郭旭辉
 *
 */
public interface IItemDAO extends IJShopBaseDAO<Item> {
 /**
  * 分页查询商品
  * @param condition  查询条件
  * @param offset     偏移量
  * @param rows       行数
  * @return  返回，分页集合
  */
 List<ItemEx> queryPageEx(@Param("condition")Map<String, Object> condition,@Param("offset")Integer offset, @Param("rows") int rows);

 /**
  * 统计商品
  * @param condition  查询条件
  * @return  返回，统计结果
  */
 int countEx(@Param("condition")Map<String, Object> condition);
}
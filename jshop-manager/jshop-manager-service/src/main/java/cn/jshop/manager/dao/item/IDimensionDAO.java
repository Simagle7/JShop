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

package cn.jshop.manager.dao.item;

import cn.jshop.manager.dao.IJShopBaseDAO;
import cn.jshop.manager.domain.item.Dimension;
import cn.jshop.manager.domain.item.DimensionEx;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
import java.util.List;

/**
 * 《商品规则参数》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IDimensionDAO extends IJShopBaseDAO<Dimension> {


    /**
     * 分页查询商品规格参数
     * @param condition 查询条件
     * @param offset    偏移量
     * @param rows      页大小
     * @return  返回，分页集合
     */
    List<DimensionEx> queryPageEx(@Param("condition") Map<String, Object> condition, @Param("offset") Integer offset, @Param("rows") Integer rows);

    /**
     * 统计分页结果
     * @param condition     查询条件
     * @return  返回，统计结果
     */
    int countEx(@Param("condition")Map<String, Object> condition);


    /**
     * 查询一条商品规格参数信息
     * @param id    商品规格参数id
     * @return  返回，一条商品规格参数信息主键
     */
    DimensionEx findOneEx(@Param("id") Long id);
}
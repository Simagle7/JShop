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

import cn.jshop.manager.dao.IJShopBaseDAO;
import cn.jshop.manager.dao.item.IDimensionRelDAO;
import cn.jshop.manager.domain.item.DimensionRel;
import cn.jshop.manager.service.AbstractJShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 /**
 * 《商品规格和商品的关系》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("DimensionRelServiceImpl")
public class DimensionRelServiceImpl extends AbstractJShopService<IJShopBaseDAO<DimensionRel>, DimensionRel> implements IDimensionRelService<IJShopBaseDAO<DimensionRel>,DimensionRel>{
    @Autowired
    private IDimensionRelDAO dimensionRelDAO;

    @Override
    public IJShopBaseDAO<DimensionRel> getDao() {
        return dimensionRelDAO;
    }

}
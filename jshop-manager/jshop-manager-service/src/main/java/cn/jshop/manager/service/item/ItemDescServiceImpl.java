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
import cn.jshop.manager.dao.item.IItemDescDAO;
import cn.jshop.manager.domain.item.ItemDesc;
import cn.jshop.manager.service.item.IItemDescService;
import cn.jshop.manager.service.AbstractJShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

 /**
 * 《商品描述》 业务逻辑服务类
 * @author simagle
 *
 */
@Service("ItemDescServiceImpl")
public class ItemDescServiceImpl extends AbstractJShopService<IJShopBaseDAO<ItemDesc>, ItemDesc> implements IItemDescService<IJShopBaseDAO<ItemDesc>,ItemDesc>{
    @Autowired
    private IItemDescDAO itemDescDAO;

    @Override
    public IJShopBaseDAO<ItemDesc> getDao() {
        return itemDescDAO;
    }

}
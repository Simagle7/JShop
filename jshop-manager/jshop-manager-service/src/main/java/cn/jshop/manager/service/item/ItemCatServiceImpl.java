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

import cn.jshop.common.domain.TreeNode;
import cn.jshop.manager.dao.IJShopBaseDAO;
import cn.jshop.manager.dao.item.IItemCatDAO;
import cn.jshop.manager.domain.item.ItemCat;
import cn.jshop.manager.service.AbstractJShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

 /**
 * 《商品类目》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("ItemCatServiceImpl")
public class ItemCatServiceImpl extends AbstractJShopService<IJShopBaseDAO<ItemCat>, ItemCat> implements IItemCatService<IJShopBaseDAO<ItemCat>,ItemCat>{
    @Autowired
    private IItemCatDAO itemCatDAO;

    @Override
    public IJShopBaseDAO<ItemCat> getDao() {
        return itemCatDAO;
    }

     @Override
     public List<TreeNode> getChildCat(int pId, Boolean allIn) {
        if (allIn){
            return itemCatDAO.getChildCat(pId, 1);
        }else {
            return itemCatDAO.getChildAvailableCat(pId,1);
        }
     }


 }
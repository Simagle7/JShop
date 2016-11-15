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
import cn.jshop.common.exception.BizException;
import cn.jshop.common.utils.ERRORCODE;
import cn.jshop.common.utils.RETURNCODE;
import cn.jshop.manager.dao.IJShopBaseDAO;
import cn.jshop.manager.dao.item.IItemDAO;
import cn.jshop.manager.dao.item.IItemDescDAO;
import cn.jshop.manager.domain.item.Item;
import cn.jshop.manager.domain.item.ItemDesc;
import cn.jshop.manager.param.item.ItemParam;
import cn.jshop.manager.param.item.ItemParamEx;
import cn.jshop.manager.service.AbstractJShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 《商品》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("ItemServiceImpl")
public class ItemServiceImpl extends AbstractJShopService<IJShopBaseDAO<Item>, Item> implements IItemService<IJShopBaseDAO<Item>,Item>{
    @Autowired
    private IItemDAO itemDAO;
    @Autowired
    private IItemDescDAO itemDescDAO;

    @Override
    public IJShopBaseDAO<Item> getDao() {
        return itemDAO;
    }

    @Override
    public String saveItem(ItemParamEx paramEx, AccountDto accountDto) {
        if(this.findOne(ItemParam.F_Title, paramEx.getTitle()) != null){
            throw new BizException(ERRORCODE.ITEM_EXISTS.getCode(), ERRORCODE.ITEM_EXISTS.getMessage());
        }
        Item item = new Item();
        item.setTitle(paramEx.getTitle());
        item.setBarcode(paramEx.getBarcode());
        item.setCid(paramEx.getCid());
        item.setSell_point(paramEx.getSell_point());
        item.setNum(paramEx.getNum());
        String price = String.valueOf(paramEx.getPriceView()*1000);
        item.setPrice(Long.valueOf(price.substring(0,price.lastIndexOf("."))));
        item.setCreator(accountDto.getUid());
        item.setCreateDate(System.currentTimeMillis());
        item.setStatus(1);
        if(this.insert(item)> 0){
            ItemDesc itemDesc = new ItemDesc();
            itemDesc.setItem_desc(paramEx.getDescription());
            itemDesc.setItem_id(item.getId());
            itemDesc.setCreated(new Date());
            if(itemDescDAO.insert(itemDesc) > 0){
                return RETURNCODE.ADD_COMPLETE.getMessage();
            }
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }
}
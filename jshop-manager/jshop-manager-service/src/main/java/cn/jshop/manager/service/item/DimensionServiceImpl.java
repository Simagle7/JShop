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
import cn.jshop.common.exception.BizException;
import cn.jshop.common.utils.ERRORCODE;
import cn.jshop.common.utils.RETURNCODE;
import cn.jshop.manager.dao.IJShopBaseDAO;
import cn.jshop.manager.dao.item.IDimensionDAO;
import cn.jshop.manager.domain.item.Dimension;
import cn.jshop.manager.param.item.DimensionParam;
import cn.jshop.manager.service.AbstractJShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

 /**
 * 《商品规则参数》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("DimensionServiceImpl")
public class DimensionServiceImpl extends AbstractJShopService<IJShopBaseDAO<Dimension>, Dimension> implements IDimensionService<IJShopBaseDAO<Dimension>,Dimension>{
    @Autowired
    private IDimensionDAO dimensionDAO;

    @Override
    public IJShopBaseDAO<Dimension> getDao() {
        return dimensionDAO;
    }

     @Override
     public ModelAndView queryPage(DimensionParam param, Integer pageNo, Integer pageSize) {
        ModelAndView mav = new ModelAndView("dimension/list");
         return mav;
     }

     @Override
     public String saveDimension(DimensionParam param, AccountDto currentUser) {
        param.setCreateDate(System.currentTimeMillis());
        param.setCreator(currentUser.getUid());
        if(this.insertMap(param.toMap()) > 0){
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(),ERRORCODE.OPERATION_FAIL.getMessage());
     }

 }
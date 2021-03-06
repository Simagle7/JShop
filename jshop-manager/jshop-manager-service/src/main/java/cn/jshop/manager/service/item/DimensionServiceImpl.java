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
import cn.jshop.common.utils.PageUtils;
import cn.jshop.common.utils.RETURNCODE;
import cn.jshop.manager.dao.IJShopBaseDAO;
import cn.jshop.manager.dao.item.IDimensionDAO;
import cn.jshop.manager.domain.item.Dimension;
import cn.jshop.manager.domain.item.DimensionEx;
import cn.jshop.manager.param.item.DimensionParam;
import cn.jshop.manager.service.AbstractJShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 《商品规则参数》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("DimensionServiceImpl")
public class DimensionServiceImpl extends AbstractJShopService<IJShopBaseDAO<Dimension>, Dimension> implements IDimensionService<IJShopBaseDAO<Dimension>, Dimension> {
    @Autowired
    private IDimensionDAO dimensionDAO;

    @Override
    public IJShopBaseDAO<Dimension> getDao() {
        return dimensionDAO;
    }

    @Override
    public ModelAndView queryPage(DimensionParam param, Integer pageNo, Integer pageSize) {
        ModelAndView mav = new ModelAndView("dimension/list");
        List<DimensionEx> data = dimensionDAO.queryPageEx(param.toMap(), (pageNo - 1) * pageSize, pageSize);
        int records = dimensionDAO.countEx(param.toMap());
        return mav.addObject("data", PageUtils.toBizData4Page(data, pageNo, pageSize, records));
    }

    @Override
    public String saveDimension(DimensionParam param, AccountDto currentUser) {
        param.setCreateDate(System.currentTimeMillis());
        param.setCreator(currentUser.getUid());
        if (this.insertMap(param.toMap()) > 0) {
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public ModelAndView update(Long id) {
        return new ModelAndView("dimension/update").addObject("item", dimensionDAO.findOneEx(id));
    }

    @Override
    public String updateDimension(DimensionParam param, AccountDto currentUser) {
        param.setLastModifier(currentUser.getUid());
        param.setLastModDate(System.currentTimeMillis());
        if (this.updateMap(param.toMap()) > 0) {
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String disabledOrEnable(DimensionParam dimensionParam, AccountDto currentUser) {
        //当操作状态为启用时，确保只能由一条模板信息是启用状态
        if (dimensionParam.getStatus().equals(0)) {
            List<Dimension> list = this.findList(DimensionParam.F_Cid, dimensionParam.getCid());
            if (list.size() > 1 || !list.get(0).getId().equals(dimensionParam.getId())) {
                throw new BizException(ERRORCODE.EXISTS_DIMENSION_ACTIVE.getCode(), ERRORCODE.EXISTS_DIMENSION_ACTIVE.getMessage());
            }
        }
        dimensionParam.setLastModDate(System.currentTimeMillis());
        dimensionParam.setLastModifier(currentUser.getUid());
        if (this.updateMap(dimensionParam.toMap()) > 0) {
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }
}
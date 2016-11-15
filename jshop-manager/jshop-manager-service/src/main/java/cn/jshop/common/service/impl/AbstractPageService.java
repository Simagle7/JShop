package cn.jshop.common.service.impl;


import cn.jshop.common.dao.IBaseDAO;
import cn.jshop.common.domain.BaseDomain;
import cn.jshop.common.domain.BizData4Page;
import cn.jshop.common.service.IPageService;
import cn.jshop.common.utils.BizData4PageBuilder;
import cn.jshop.common.utils.SqlOrderEnum;

import java.util.List;
import java.util.Map;

/**
 * Created by 郭旭辉 on 2016/3/13.
 */
public abstract class AbstractPageService<D extends IBaseDAO,T extends BaseDomain> extends AbstractBaseService<D,T> implements IPageService<D,T> {

    @Override
    public BizData4Page queryPageByDataPerm(String resUri, Map<String, Object> conditions, int curPage, int offset, int rows) {
        return BizData4PageBuilder.createBizData4Page(getDao(), conditions, curPage, offset, rows);
    }

    @Override
    public BizData4Page queryPageByDataPerm(String resUri, Map<String, Object> conditions, int curPage, int offset, int rows, String orderBy, SqlOrderEnum sqlOrderEnum) {
        return BizData4PageBuilder.createBizData4Page(getDao(), conditions, curPage, offset, rows);
    }

    /**
     * 条件查询包含各种查询
     * @return
     */
    public void queryPageByDataPerm(BizData4Page bizData4Page, String orderBy, SqlOrderEnum sqlOrderEnum)
    {
        int offset = (bizData4Page.getPage()-1)*bizData4Page.getPageSize();
        int rows = bizData4Page.getPageSize();
        List<T> mainData = getDao().queryPage(bizData4Page.getConditions(), offset, rows, orderBy, sqlOrderEnum.getAction(),null);
        int records =  getDao().count(bizData4Page.getConditions());

        bizData4Page.setRows(mainData);
        bizData4Page.setPage(bizData4Page.getPage());
        bizData4Page.setRecords(records);

        int total = records / rows;
        int mod = records % rows;
        if(mod > 0){
            total = total + 1;
        }
        bizData4Page.setTotal(total);
    }

    /**
     * 条件查询包含各种查询
     * @return
     */
    public void queryPageByDataPerm(BizData4Page bizData4Page)
    {
        int offset = (bizData4Page.getPage()-1)*bizData4Page.getPageSize();
        int rows = bizData4Page.getPageSize();
        List<T> mainData = getDao().queryPage(bizData4Page.getConditions(), offset, rows, null, null,null);
        int records =  getDao().count(bizData4Page.getConditions());

        bizData4Page.setRows(mainData);
        bizData4Page.setPage(bizData4Page.getPage());
        bizData4Page.setRecords(records);

        int total = records / rows;
        int mod = records % rows;
        if(mod > 0){
            total = total + 1;
        }
        bizData4Page.setTotal(total);
    }


    /***
     * 条件查询包含各种查询
     * baseDAO 主要为扩展exdao
     * @param baseDAO
     * @param bizData4Page
     */
    public void queryPageByDataPerm(IBaseDAO baseDAO,BizData4Page bizData4Page)
    {
        int offset = (bizData4Page.getPage()-1)*bizData4Page.getPageSize();
        int rows = bizData4Page.getPageSize();
        List<T> mainData = baseDAO.queryPage(bizData4Page.getConditions(), offset, rows, null, null,null);
        int records =  baseDAO.count(bizData4Page.getConditions());

        bizData4Page.setRows(mainData);
        bizData4Page.setPage(bizData4Page.getPage());
        bizData4Page.setRecords(records);

        int total = records / rows;
        int mod = records % rows;
        if(mod > 0){
            total = total + 1;
        }
        bizData4Page.setTotal(total);
    }

    /***
     * 条件查询包含各种查询
     * baseDAO 主要为扩展exdao
     * @param baseDAO
     * @param bizData4Page
     */
    public void queryPageByDataPerm(IBaseDAO baseDAO,BizData4Page bizData4Page, String orderBy, SqlOrderEnum sqlOrderEnum)
    {
        int offset = (bizData4Page.getPage()-1)*bizData4Page.getPageSize();
        int rows = bizData4Page.getPageSize();
        List<T> mainData = baseDAO.queryPage(bizData4Page.getConditions(), offset, rows, orderBy, sqlOrderEnum.getAction(),null);
        int records =  baseDAO.count(bizData4Page.getConditions());

        bizData4Page.setRows(mainData);
        bizData4Page.setPage(bizData4Page.getPage());
        bizData4Page.setRecords(records);

        int total = records / rows;
        int mod = records % rows;
        if(mod > 0){
            total = total + 1;
        }
        bizData4Page.setTotal(total);
    }


    /**
     * 条件查询包含各种查询
     * @return
     */
    public void queryPageByDataPerm(BizData4Page bizData4Page, String orderBy, SqlOrderEnum sqlOrderEnum, Map<String, Object> selector)
    {
        queryPageByDataPerm(getDao(),bizData4Page,orderBy,sqlOrderEnum,selector);
    }

    /**
     * 条件查询包含各种查询
     * @return
     */
    public void queryPageByDataPerm(IBaseDAO dao,BizData4Page bizData4Page, String orderBy, SqlOrderEnum sqlOrderEnum, Map<String, Object> selector)
    {
        int offset = (bizData4Page.getPage()-1)*bizData4Page.getPageSize();
        int rows = bizData4Page.getPageSize();
        List<T> mainData = dao.queryPage(bizData4Page.getConditions(), offset, rows, orderBy, sqlOrderEnum.getAction(), selector);
        int records =  dao.count(bizData4Page.getConditions());

        bizData4Page.setRows(mainData);
        bizData4Page.setPage(bizData4Page.getPage());
        bizData4Page.setRecords(records);

        int total = (records-1) / rows+1;
        bizData4Page.setTotal(total);
    }

    /**
     * 具有排序的分页
     * @param dao
     * @param conditions
     * @param curPage
     * @param offset
     * @param rows
     * @param orderBy
     * @param sqlOrderEnum
     * @return
     */
    public BizData4Page queryPageByDataPerm(IBaseDAO dao, Map<String, Object> conditions, int curPage, int offset, int rows, String orderBy, SqlOrderEnum sqlOrderEnum, Map<String, Object> selector)
    {
        List mainData = dao.queryPage(conditions, offset, rows, orderBy, sqlOrderEnum.getAction(),selector);
        int records = dao.count(conditions);

        BizData4Page bizData4Page = new BizData4Page();
        bizData4Page.setRows(mainData);
        bizData4Page.setPage(curPage);
        bizData4Page.setRecords(records);

        int total = records / rows;
        int mod = records % rows;
        if(mod > 0){
            total = total + 1;
        }
        bizData4Page.setTotal(total);

        return bizData4Page;
    }



}

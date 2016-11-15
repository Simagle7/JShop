package cn.jshop.common.service;


import cn.jshop.common.dao.IBaseDAO;
import cn.jshop.common.domain.BaseDomain;
import cn.jshop.common.domain.BizData4Page;
import cn.jshop.common.utils.SqlOrderEnum;

import java.util.Map;

/**
 * Created by 郭旭辉 on 2016/3/13.
 * 进行分页数据查询的service
 */

public interface IPageService<D extends IBaseDAO, T extends BaseDomain> {
    /**
     * 数据权限后的分页数据获取
     * @param resUri
     * @param conditions
     * @param curPage
     * @param offset
     * @param rows
     * @return
     */
    public BizData4Page queryPageByDataPerm(String resUri, Map<String, Object> conditions, int curPage, int offset, int rows);

    /**
     * 条件查询包含各种查询
     * @param bizData4Page
     */
    public void queryPageByDataPerm(BizData4Page bizData4Page);

    /**
     * 条件查询包含各种查询
     * @param baseDAO   主要为拓展的dao
     * @param bizData4Page
     */
    void queryPageByDataPerm(IBaseDAO baseDAO, BizData4Page bizData4Page);

    /**
     * 条件查询包含各种查询
     * @param bizData4Page
     * @param orderBy       排序字段
     * @param sqlOrderEnum
     */
    public void  queryPageByDataPerm(BizData4Page bizData4Page, String orderBy, SqlOrderEnum sqlOrderEnum);

    /**
     * 具有排序的分页
     * @param resUri
     * @param conditions
     * @param curPage
     * @param offset
     * @param rows
     * @param orderBy
     * @param sqlOrderEnum
     * @return
     */
    public BizData4Page queryPageByDataPerm(String resUri, Map<String, Object> conditions, int curPage, int offset, int rows, String orderBy, SqlOrderEnum sqlOrderEnum);

    /**
     * 条件查询包含各种查询
     * @param bizData4Page
     * @param orderBy
     * @param sqlOrderEnum
     * @param selector
     */
    public void queryPageByDataPerm(BizData4Page bizData4Page, String orderBy, SqlOrderEnum sqlOrderEnum, Map<String, Object> selector);

    public void queryPageByDataPerm(IBaseDAO dao, BizData4Page bizData4Page, String orderBy, SqlOrderEnum sqlOrderEnum, Map<String, Object> selector);

    /**
     * 具有排序的字段
     * @param dao
     * @param conditions
     * @param curPage
     * @param offset
     * @param rows
     * @param orderBy
     * @param sqlOrderEnum
     * @param selector
     * @return
     */
    public BizData4Page queryPageByDataPerm(IBaseDAO dao, Map<String, Object> conditions, int curPage, int offset, int rows, String orderBy, SqlOrderEnum sqlOrderEnum, Map<String, Object> selector);
}

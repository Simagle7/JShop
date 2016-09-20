package cn.jshop.common.service;


import cn.jshop.common.dao.IBaseDAO;
import cn.jshop.common.domain.BaseDomain;

/**
 * Created by 郭旭辉 on 2016/3/13.
 * 业务主对象DAO注入
 */

public interface IDaoAware<D extends IBaseDAO, T extends BaseDomain> {
    public D getDao();
}

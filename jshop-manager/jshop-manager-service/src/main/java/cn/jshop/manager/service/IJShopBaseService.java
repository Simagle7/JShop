package cn.jshop.manager.service;


import cn.jshop.common.domain.BaseDomain;
import cn.jshop.common.service.IBaseService;
import cn.jshop.common.service.IPageService;
import cn.jshop.manager.dao.IJShopBaseDAO;

/**
 * Created by 郭旭辉 on 2016/3/13.
 */
public interface IJShopBaseService<D extends IJShopBaseDAO<T>, T extends BaseDomain> extends IBaseService<D, T>, IPageService<D, T> {
}

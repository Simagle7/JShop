package cn.jshop.ssm.service;


import cn.jshop.common.domain.BaseDomain;
import cn.jshop.common.service.IBaseService;
import cn.jshop.ssm.dao.IJShopBaseDAO;

/**
 * Created by 郭旭辉 on 2016/3/13.
 */

public interface IJShopBaseService<D extends IJShopBaseDAO<T>, T extends BaseDomain> extends IBaseService<D, T>{
}

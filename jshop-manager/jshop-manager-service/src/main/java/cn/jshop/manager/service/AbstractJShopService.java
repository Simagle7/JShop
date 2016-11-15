package cn.jshop.manager.service;


import cn.jshop.common.domain.BaseDomain;
import cn.jshop.common.service.impl.AbstractPageService;
import cn.jshop.manager.dao.IJShopBaseDAO;

/**
 * Created by 郭旭辉 on 2016/3/13.
 */

public abstract class AbstractJShopService<D extends IJShopBaseDAO,T extends BaseDomain> extends AbstractPageService<D, T> {

}

package cn.jshop.ssm.service;

import cn.jshop.common.domain.BaseDomain;
import cn.jshop.common.service.impl.AbstractBaseService;
import cn.jshop.ssm.dao.IJShopBaseDAO;

/**
 * Created by 郭旭辉 on 2016/3/13.
 */

public abstract class AbstractJShopService<D extends IJShopBaseDAO,T extends BaseDomain> extends AbstractBaseService<D,T> {

}

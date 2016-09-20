/*
{*****************************************************************************
{  商城 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉——詹晓锋. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-09-20  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package cn.jshop.ssm.service.tb;

import cn.jshop.ssm.dao.IJShopBaseDAO;
import cn.jshop.ssm.dao.tb.IUserDAO;
import cn.jshop.ssm.domain.tb.EasyUIResult;
import cn.jshop.ssm.domain.tb.User;
import cn.jshop.ssm.service.AbstractJShopService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 《用户表》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("UserServiceImpl")
public class UserServiceImpl extends AbstractJShopService<IJShopBaseDAO<User>, User> implements IUserService<IJShopBaseDAO<User>,User>{
    @Autowired
    private IUserDAO userDAO;

    @Override
    public IJShopBaseDAO<User> getDao() {
        return userDAO;
    }

    @Override
    public EasyUIResult queryUserList(Integer page, Integer rows) {
        // 设置分页参数
        PageHelper.startPage(page, rows);
        List users = this.findAll();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }
}
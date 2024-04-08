package com.atguigu.schedule.service.impl;

import com.atguigu.schedule.dao.SysUserDao;
import com.atguigu.schedule.dao.impl.SysUserDaoImpl;
import com.atguigu.schedule.pojo.SysUser;
import com.atguigu.schedule.service.SysUserService;
import com.atguigu.schedule.util.MD5Util;

public class SysUserServiceImpl implements SysUserService {
    private SysUserDao userDao=  new SysUserDaoImpl();
    @Override
    public int register(SysUser registerUser) {
        //将密码加密
        registerUser.setUserPwd(MD5Util.encrypt(registerUser.getUserPwd()));
        //调用DAO插入数据库
        return userDao.addSysUser(registerUser);
    }

    @Override
    public SysUser findByUsername(String username) {

        return userDao.findByUsername(username);
    }
}

package com.atguigu.schedule.service;

import com.atguigu.schedule.pojo.SysUser;

/*
* 该接口定义了以sys_user表格为核心的业务处理功能
*
*
* */
public interface SysUserService {
    /**
     * 实现用户注册
     * @param registerUser 注册用户实体
     * @return 数据库影响行数
     */
    int register(SysUser registerUser);

    /**
     * 根据用户名获得完整用户信息的方法
     * @param username 要查询的用户名
     * @return 如果找到了返回SysUser对象,找不到返回null
     */
    SysUser findByUsername(String username);
}

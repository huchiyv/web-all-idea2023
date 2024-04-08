package com.atguigu.schedule.dao;

import com.atguigu.schedule.pojo.SysUser;

/*
* Data access Object 数据访问对象
* 该类中用于定义针对表格的CRUD方法
* DAO层一般需要定义接口和实现类
*
*
*
* */
public interface SysUserDao {
    /**
     * 添加一个用户
     * @param sysUser 用户实体
     * @return 数据库修改行数 0：增加失败，1：增加成功
     */
    public int addSysUser(SysUser sysUser);

    /**
     * 根据用户名获得完整用户信息的方法
     * @param username 要查询的用户名
     * @return 如果找到了返回SysUser对象,找不到返回null
     */
    SysUser findByUsername(String username);
}

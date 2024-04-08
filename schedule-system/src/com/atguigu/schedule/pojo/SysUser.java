package com.atguigu.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/*
* 1.实体类的类名和表格名称应该对应
* 2.实体类属性名和表格列名对应
* 3.每个属性应该是私有的
* 4.每个属性应该具备getter setter
* 5.必须具备无参构造器
* 6.应该实现序列化接口（缓存 分布式项目数据传递 可能会将对象序列化）
* 7.应该重写类的hashcode和equals方法
* 8.toString是否重写都可以
*
*
* 使用lombok插件帮助我们生成这些内容getter setter 全参构造，无参构造，equals hashcode
* 使用步骤：
* 1.安装插件lombok
* 2.检查是否勾选了enable annotation processing
* 3.导入lombok的依赖，在实体类上添加注解
*
*
* */
@AllArgsConstructor//添加了全参构造
@NoArgsConstructor  //添加了无参构造
@Data //getter setter equals hashcode
public class SysUser implements Serializable {
    private Integer uid;
    private  String username;
    private String userPwd;
}

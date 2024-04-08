package com.atguigu.schedule.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor//添加了全参构造
@NoArgsConstructor  //添加了无参构造
@Data //getter setter equals hashcode
public class SysSchedule implements Serializable {
    private Integer sid;
    private Integer uid;
    private String title;
    private Integer completed;
}

package com.atguigu.schedule.test;

import com.atguigu.schedule.dao.SysScheduleDao;
import com.atguigu.schedule.dao.impl.SysScheduleDaoImpl;
import com.atguigu.schedule.pojo.SysSchedule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class TestSysScheduleDao {
    static SysScheduleDao sysScheduleDao;

    @BeforeClass
    public static void initScheduleDao(){

        sysScheduleDao=new SysScheduleDaoImpl();
    }

    @Test
    public void testAddSchedule(){
        int rows= sysScheduleDao.addSchedule(new SysSchedule());
        System.out.println(rows);

    }

    @Test
    public void testFinaAll(){
        List<SysSchedule> allList = sysScheduleDao.findAll();
        allList.forEach(System.out::println);
    }
}

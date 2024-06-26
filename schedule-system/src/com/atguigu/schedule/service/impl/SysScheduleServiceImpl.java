package com.atguigu.schedule.service.impl;

import com.atguigu.schedule.dao.impl.SysScheduleDaoImpl;
import com.atguigu.schedule.pojo.SysSchedule;
import com.atguigu.schedule.service.SysScheduleService;

import java.util.List;

public class SysScheduleServiceImpl implements SysScheduleService {

   private SysScheduleDaoImpl  sysScheduleDao = new SysScheduleDaoImpl();
    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        return sysScheduleDao.findItemListByUid(uid);
    }

    @Override
    public Integer addDefault(int uid) {
        return sysScheduleDao.addDefault(uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule sysSchedule) {
        return sysScheduleDao.updateSchedule(sysSchedule);
    }

    @Override
    public Integer removeSchedule(int sid) {
        return sysScheduleDao.removeSchedule(sid);
    }
}

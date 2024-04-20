package com.atguigu.schedule.controller;

import com.atguigu.schedule.common.Result;
import com.atguigu.schedule.pojo.SysSchedule;
import com.atguigu.schedule.service.SysScheduleService;
import com.atguigu.schedule.service.SysUserService;
import com.atguigu.schedule.service.impl.SysScheduleServiceImpl;
import com.atguigu.schedule.service.impl.SysUserServiceImpl;
import com.atguigu.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;


/*
* 增加日程的请求   /schedule/add
* 查询日程的请求   /schedule/find
* 修改日程的请求   /schedule/update
* 删除日程的请求   /schedule/remove
* 。。。。
*
*
* */
@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {

    private SysScheduleService sysScheduleService=new SysScheduleServiceImpl();

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //判断此次请求时是 增？删？改？查？
//        String requestURI = req.getRequestURI(); // /schedule/add
//        String[] split = requestURI.split("/");
//        String methodName = split[split.length - 1];
////        if (methodName.equals("add")) {
////            add(req,resp);
////        } else if (methodName.equals("find")) {
////            find(req,resp);
////
////        } else if (methodName.equals("update")) {
////            update(req,resp);
////
////        } else if (methodName.equals("remove")) {
////            remove(req,resp);
////
////        }
//
//        Class<? extends SysScheduleController> aClass = this.getClass();
//        Method declaredMethod = null;
//        try {
//            declaredMethod = aClass.getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
//        } catch (NoSuchMethodException e) {
//            //throw new RuntimeException(e);
//            e.printStackTrace();
//        }
//        declaredMethod.setAccessible(true);
//        try {
//            declaredMethod.invoke(this,req,resp);
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            //throw new RuntimeException(e);
//            e.printStackTrace();
//        }
//    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
    }

    protected void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("find");

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("update");

    }

    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("remove");

    }

    protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收请求中的uid参数
        int uid = Integer.parseInt(req.getParameter("uid"));

        //查询用户的所有日程
        List<SysSchedule> itemList= sysScheduleService.findItemListByUid(uid);

        //将用户的所有日程放入一个Result对象
        HashMap data = new HashMap();
        data.put("itemList",itemList);

        Result<HashMap> result = Result.ok(data);
        //将Result对象转化未json响应给客户端
        WebUtil.writeJson(resp,result);


    }

    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收请求中的uid参数
        int uid = Integer.parseInt(req.getParameter("uid"));

        //查询用户的所有日程
        sysScheduleService.addDefault(uid);

        WebUtil.writeJson(resp,Result.ok(null));
    }

    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收请求体重的JSON串，转成一个对象
        SysSchedule sysSchedule = WebUtil.readJson(req, SysSchedule.class);
        sysScheduleService.updateSchedule(sysSchedule);
        WebUtil.writeJson(resp,Result.ok(null));
    }

    protected void removeSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));

        sysScheduleService.removeSchedule(sid);

        WebUtil.writeJson(resp,Result.ok(null));

    }
}

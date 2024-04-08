package com.atguigu.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


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
}

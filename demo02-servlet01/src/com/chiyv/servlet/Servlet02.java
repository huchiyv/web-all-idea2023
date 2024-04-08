package com.chiyv.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/servlet02")
public class Servlet02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //获取键值对
            //根据参数名获取参数值
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("userPwd"));
        //根据参数名获取多个参数
        System.out.println(Arrays.toString(req.getParameterValues("hobby")));

        //先获取所有的参数名
        Enumeration<String> names = req.getParameterNames();
        //遍历所有值
        while(names.hasMoreElements()){
            String pname = names.nextElement();
            System.out.println(pname + ":" + req.getParameter(pname));
        }

        //获取所有键值对map
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            System.out.println(stringEntry.getKey() + "=" + Arrays.toString(stringEntry.getValue()) );
        }

        //获取非键值对
        //JSON串，文件

        BufferedReader reader = req.getReader();//获得字符流读取JSON串
        ServletInputStream inputStream = req.getInputStream();//获取字节流传输文件

    }
}

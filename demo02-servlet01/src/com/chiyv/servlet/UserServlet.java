package com.chiyv.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        //1.获取请求数据
        String username = req.getParameter("username");

        //2.处理请求数据
        String info="YES";
        if("atguigu".equals(username)){
            info="NO";
        }

        //3.返回请求数据
        PrintWriter respWriter = resp.getWriter();
        respWriter.write(info);
    }
}

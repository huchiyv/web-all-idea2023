package com.chiyv.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet01")
public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求方法
        System.out.println(req.getMethod());
        //获取请求协议
        System.out.println(req.getScheme());
        //获取协议以及版本
        System.out.println(req.getProtocol());
        //获取URI
        System.out.println(req.getRequestURI());
        //获取URL
        System.out.println(req.getRequestURL());

        //获取端口
        System.out.println(req.getLocalPort());//本应用所在容器的端口：这里容器为
    }
}

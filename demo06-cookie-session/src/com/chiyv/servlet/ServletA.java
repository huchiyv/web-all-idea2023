package com.chiyv.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建cookie
        Cookie cookiea = new Cookie("namea", "valuea");
        Cookie cookieb = new Cookie("nameb", "valueb");
        //2.使用cookie
        resp.addCookie(cookiea);
        resp.addCookie(cookieb);

        //向请求域存放数据
        req.setAttribute("request","requestMessage");

        //向会话域中存放数据
        HttpSession session = req.getSession();
        session.setAttribute("session","sessionMessage");

        //向应用域中存放数据
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("application","applicationMessage");

        req.getRequestDispatcher("/servletB").forward(req,resp);


    }
}

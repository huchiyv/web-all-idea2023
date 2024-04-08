package com.atguigu.schedule.controller;

import com.atguigu.schedule.common.Result;
import com.atguigu.schedule.common.ResultCodeEnum;
import com.atguigu.schedule.pojo.SysUser;
import com.atguigu.schedule.service.SysUserService;
import com.atguigu.schedule.service.impl.SysUserServiceImpl;
import com.atguigu.schedule.util.MD5Util;
import com.atguigu.schedule.util.WebUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/user/*")
public class SysUserController extends BaseController {

    private SysUserService sysUserService=new SysUserServiceImpl();

    /**
     * 注册时接收要注册的用户名，校验用户名是否被占用的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUserNameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收用户名
        String username = req.getParameter("username");
        //调用服务层业务处理方法查询该用户名是否被占用
        SysUser registerUser = sysUserService.findByUsername(username);
        //响应
        String info = "已被占用";
        Result result=Result.ok(null);
        result=Result.build(null, ResultCodeEnum.USERNAME_USED);

        if(null==registerUser){
            info="可用";
            result= Result.build(null, ResultCodeEnum.SUCCESS);

        }
        //ObjectMapper,响应给客户端
        WebUtil.writeJson(resp,result);


    }

    /**
     * 接收用户注册请求的业务处理方法（业务接口，不是interface）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收客户端提交的参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("password");
        //2.调用服务层的方法完成注册业务
            //2.1把参数放入对象中
        SysUser sysUser = new SysUser(null, username, userPwd);
        int rows = sysUserService.register(sysUser);
        //根据注册结果跳转页面
        if(rows>0){
            resp.sendRedirect("/registerSuccess.html");
        }else{
            resp.sendRedirect("/registFail.html");
        }
    }

    /**
     * 接收用户登录请求，完成登录业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收客户端提交的参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("password");
        //2.调用服务层方法完成登录业务
            //2.1把参数放入对象中
        SysUser loginUser = new SysUser(null, username, userPwd);
        SysUser sysUser = sysUserService.findByUsername(loginUser.getUsername());
        //3.根据完整信息判断密码是否正确
       if(null==sysUser){
           resp.sendRedirect("/loginUserNameError.html");
       }else if(MD5Util.encrypt(loginUser.getUserPwd()) .equals(sysUser.getUserPwd())){
           resp.sendRedirect("/showSchedule.html");
       }else{
           resp.sendRedirect("/loginUserPwdError.html");
       }

       //4.登录成功，把登录信息存入session
        HttpSession session = req.getSession();
       session.setAttribute("sysUser",loginUser);
       //5.重定向跳转页面
       resp.sendRedirect("/showSchedule.html");
    }
}

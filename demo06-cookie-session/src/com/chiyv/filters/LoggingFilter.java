package com.chiyv.filters;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * 日志过滤器 记录请求的历史 将日志打印到控制台
 *
 * 1.实现Filter接口
 * 2.重写过滤方法
 * 3.配置过滤器
 *  web.xml
 *  注解
 *
 */
public class LoggingFilter implements Filter {

    /**
     * 过滤请求和响应的方法
     *  1.请求到达目标资源前经过此方法
     *  2.该方法有能力控制请求是否继续向后到达目标资源 可以在方法内直接响应客户端
     *  3.请求到资源回去时候还会经过该方法
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.请求到达目标资源前的功能
        System.out.println("loggingFilter before");
        //2.放行代码
        filterChain.doFilter(servletRequest,servletResponse);
        //3.响应前代码
        System.out.println("loggingFilter after");
    }
}

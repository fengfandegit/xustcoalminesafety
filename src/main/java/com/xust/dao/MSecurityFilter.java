package com.xust.dao;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2018/5/23.
 */
@Order(1)
@WebFilter(filterName = "MSecurity",urlPatterns = {"*.html"})
public class MSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT");
        res.addHeader("Access-Control-Allow-Headers", "Content-Type");
        res.setCharacterEncoding("UTF-8");
        filter.doFilter(request, res);
    }

    @Override
    public void destroy() {

    }
}

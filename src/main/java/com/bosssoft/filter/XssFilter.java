package com.bosssoft.filter;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * @author 吴志鸿
 * @date 2020/7/14
 * @description 过滤XSS请求的入口
 */
@Slf4j
@WebFilter
@Component
public class XssFilter implements Filter {

    private static Logger logger = LoggerFactory.getLogger(XssFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if (logger.isDebugEnabled()) {
            logger.debug("xss filter is open");
        }
        HttpServletRequest req = (HttpServletRequest) request;
        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(req);
        filterChain.doFilter(xssRequest, response);
    }

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("filter inin......");
    }

    @Override
    public void destroy() {
        logger.info("filter destroy......");
    }

}

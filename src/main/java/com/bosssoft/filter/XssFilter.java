package com.bosssoft.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private static boolean IS_INCLUDE_RICH_TEXT = false;//是否过滤富文本内容

    public List<String> excludes = new ArrayList<>();

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if (logger.isDebugEnabled()) {
            logger.debug("xss filter is open");
        }

        HttpServletRequest req = (HttpServletRequest) request;


        XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(req);
        filterChain.doFilter(xssRequest, response);
    }

//    private boolean handleExcludeURL(HttpServletRequest request, HttpServletResponse response) {
//
//        if (excludes == null || excludes.isEmpty()) {
//            return false;
//        }
//
//        String url = request.getServletPath();
//
//        for (String pattern : excludes) {
//            Pattern p = Pattern.compile("^" + pattern);
//            Matcher m = p.matcher(url);
//            if (m.find()) {
//                return true;
//            }
//        }
//
//        return false;
//    }

    @Override
    public void init(FilterConfig filterConfig) {
//        if (logger.isDebugEnabled()) {
//            logger.debug("xss filter init~~~~~~~~~~~~");
//        }
//        String isIncludeRichText = filterConfig.getInitParameter("isIncludeRichText");
//        if (StringUtils.isNotBlank(isIncludeRichText)) {
//            IS_INCLUDE_RICH_TEXT = BooleanUtils.toBoolean(isIncludeRichText);
//        }
//
//        String temp = filterConfig.getInitParameter("excludes");
//        if (temp != null) {
//            String[] url = temp.split(",");
//            for (int i = 0; url != null && i < url.length; i++) {
//                excludes.add(url[i]);
//            }
//        }
    }

    @Override
    public void destroy() {
    }

    @Bean
    @Primary
    public ObjectMapper xssObjectMapper(Jackson2ObjectMapperBuilder builder) {
        //解析器
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        //注册xss解析器
        SimpleModule xssModule = new SimpleModule("JsonHtmlXssDeserializer");
        xssModule.addSerializer(new JsonHtmlXssDeserializer());
        objectMapper.registerModule(xssModule);
        //返回
        return objectMapper;
    }

}

package com.tencent.wxcloudrun.config;

import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.ContentCachingRequestWrapper;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
public class CachingRequestBodyFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest currentRequest = (HttpServletRequest) request;
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(currentRequest);
        chain.doFilter(wrappedRequest, response);
    }
}


package org.cssa.admin.util;


import com.alibaba.fastjson2.JSON;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cssa.admin.model.Jwtutil;
import org.cssa.admin.model.Response;
import org.cssa.admin.model.ReturnCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@Component
public class AdminServiceInterceptor implements HandlerInterceptor {

    @Autowired
    Jwtutil jwtutil;
    private final Logger logger = LoggerFactory.getLogger(AdminServiceInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        PrintWriter writer = null;
        try{
            Optional<String> token = Optional.ofNullable(request.getHeader("Authorization"));
            if(token.isEmpty() || !jwtutil.isTokenValid(token.get())) {
                logger.info("filter admin request to " + request.getRequestURI() + "because of no token");
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json;charset:utf-8");
                writer = response.getWriter();
                writer.print(JSON.toJSON(new Response(ReturnCode.INVALID_ADMIN_TOKEN)));
                return false;
            }
        }catch (IOException ignored){
            logger.warn("fail to write to response");
        } finally {
            if(writer != null){
                writer.close();
            }
        }
        return true;
    }

}

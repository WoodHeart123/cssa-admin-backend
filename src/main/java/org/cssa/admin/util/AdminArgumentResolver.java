package org.cssa.admin.util;

import org.cssa.admin.dao.AdminMapper;
import org.cssa.admin.model.Jwtutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class AdminArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    Jwtutil jwtutil;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(InjectAdmin.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        String token = webRequest.getHeader("Authorization");
        Integer adminID = jwtutil.getUidFromToken(token);
        return adminMapper.getAdmin(adminID);
    }

}
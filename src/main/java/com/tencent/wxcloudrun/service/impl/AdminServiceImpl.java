package com.tencent.wxcloudrun.service.impl;


import com.alibaba.fastjson.JSON;
import com.tencent.wxcloudrun.dao.AdminMapper;
import com.tencent.wxcloudrun.model.*;
import com.tencent.wxcloudrun.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    Jwtutil jwtutil;

    public Response<Object> register(Admin admin) {
        admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
        try{
            adminMapper.register(admin);
            return new Response<>(ReturnCode.SUCCESS);
        }catch (Exception e){
            return new Response<>(ReturnCode.DUPLICATE_USERNAME);
        }

    }

    @Override
    public Response<List<Admin>> getAdminList() {
        return new Response<>(adminMapper.getAdminList());
    }

    @Override
    public Response<Admin> login(Admin admin) {
        admin.setPassword(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()));
        Admin result = this.adminMapper.login(admin);
        if (result != null) {
            result.setToken(jwtutil.generateToken(admin.getUsername()));
            return new Response<>(result);
        } else {
            return new Response<>(ReturnCode.INVALID_ADMIN_INFO);
        }
    }

}

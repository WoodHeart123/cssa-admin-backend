package org.cssa.admin.service.impl;


import org.cssa.admin.dao.AdminMapper;
import org.cssa.admin.model.Admin;
import org.cssa.admin.model.Jwtutil;
import org.cssa.admin.model.Response;
import org.cssa.admin.model.ReturnCode;
import org.cssa.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
            return new Response<>(ReturnCode.INVALID_ADMIN_TOKEN);
        }
    }

}

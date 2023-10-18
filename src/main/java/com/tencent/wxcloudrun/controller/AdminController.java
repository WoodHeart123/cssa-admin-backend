package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.model.*;
import com.tencent.wxcloudrun.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping({"/admin"})
@Api(tags = "管理员接口")
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    Jwtutil jwtutil;

    @RequestMapping(value = {"/login"}, method = {RequestMethod.POST})
    @Operation(summary = "管理员登录", description = "管理员登录")
    public Response<Admin> login(@Parameter(description = "管理员的用户名和密码") @RequestBody Admin admin) {
        return adminService.login(admin);
    }

    @RequestMapping(value = {"/register"}, method = {RequestMethod.POST})
    @Operation(summary = "管理员注册", description = "管理员注册")
    public Response<Object> register(@Parameter(description = "管理员注册密码和用户名") @RequestBody Admin admin, @RequestParam String authJWT) {
        if(jwtutil.isTokenValid(authJWT)){
            return adminService.register(admin);
        }else{
            return new Response<>(ReturnCode.INVALID_ADMIN_TOKEN);
        }

    }

    @RequestMapping(value = {"/list"}, method = {RequestMethod.GET})
    @Operation(summary = "管理员列表", description = "获取全部管理员列表")
    public Response<List<Admin>> getAdminList(){
        return adminService.getAdminList();
    }

    @RequestMapping(value = {"/invite"}, method={RequestMethod.GET})
    @Operation(summary = "获取邀请JWT", description = "获取邀请JWT")
    public Response<String> invite(@RequestParam String username){
        return new Response<>(jwtutil.generateTokenWithExpiration(username, (long) (3600 * 24)));
    }


}

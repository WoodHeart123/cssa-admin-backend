package com.tencent.wxcloudrun.service;


import com.tencent.wxcloudrun.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    Response<Admin> login(Admin admin);

    Response<Object> register(Admin admin);

    Response<List<Admin>> getAdminList();

}

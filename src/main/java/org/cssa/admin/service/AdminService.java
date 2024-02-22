package org.cssa.admin.service;


import org.cssa.admin.model.Admin;
import org.cssa.admin.model.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    Response<Admin> login(Admin admin);

    Response<Object> register(Admin admin);

    Response<List<Admin>> getAdminList();

}

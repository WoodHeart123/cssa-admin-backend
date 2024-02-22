package org.cssa.admin.dao;


import org.apache.ibatis.annotations.Mapper;
import org.cssa.admin.model.Admin;

import java.util.List;

@Mapper
public interface AdminMapper {

    /**
     * login method for admin
     *
     * @param admin password and username
     * @return 0 for mismatch, 1 for success
     */
    Admin login(Admin admin);

    //Integer checkUsername(String username);

    void register(Admin admin);

    List<Admin> getAdminList();

}

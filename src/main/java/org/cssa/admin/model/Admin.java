package org.cssa.admin.model;


import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Admin {
    public enum Division {
        JISHU,
        WAILIAN,
        HUODONG,
        DUOMEITI,
        XUANCHUAN,
        YANJIUSHENG
    }

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String username;
    @JSONField(serialize = false)
    private String password;
    private Integer avatar;
    private Division department;
    private Boolean isSuperuser;
    private Timestamp createdAt;
    private String token;
}

package org.cssa.admin.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.cssa.admin.model.Admin;
import org.cssa.admin.model.Propaganda;
import org.cssa.admin.model.Response;
import org.cssa.admin.util.InjectAdmin;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping({"/propaganda"})
@Tag(name = "宣传中心")
public class PropagandaController {

    @RequestMapping(value={"/list"}, method = {RequestMethod.GET})
    @Operation(description = "查看文宣预约情况")
    public Response<List<Propaganda>> getPropagandaList(@Parameter(description = "开始时间") @RequestParam Timestamp from,
                                                        @Parameter(description = "结束时间") @RequestParam Timestamp to){
        return null;
    }

    @RequestMapping(value={"/create"}, method = {RequestMethod.POST})
    @Operation(description = "创建文宣")
    public Response<Object> createPropaganda(@Parameter(description = "文宣细节") @RequestBody Propaganda propaganda,
                                             @Parameter(description = "管理员信息") @InjectAdmin Admin admin){
        return null;
    }

    @RequestMapping(value={"/create"}, method = {RequestMethod.DELETE})
    @Operation(description = "逻辑删除文宣")
    public Response<Object> deletePropaganda(@Parameter(description = "开始时间") @RequestBody Propaganda propaganda,
                                             @Parameter(description = "管理员信息") @InjectAdmin Admin admin){
        return null;
    }

    @RequestMapping(value={"/create"}, method = {RequestMethod.DELETE})
    @Operation(description = "分配文宣排版人员")
    public Response<Object> assignPropaganda(@Parameter(description = "用户id") @RequestBody List<Integer> userID,
                                             @Parameter(description = "管理员信息") @InjectAdmin Admin admin){
        return null;
    }




}

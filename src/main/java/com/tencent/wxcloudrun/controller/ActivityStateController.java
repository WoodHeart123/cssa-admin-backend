package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.model.Activity;
import com.tencent.wxcloudrun.model.ActivityState;
import com.tencent.wxcloudrun.model.Response;
import com.tencent.wxcloudrun.service.ActivityStateService;
import com.tencent.wxcloudrun.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping({"/activityState"})
@Api(tags = "活动中心")
public class ActivityStateController {
    @Autowired
    ActivityStateService activityStateService;

    @Autowired
    EmailService emailService;

    @Operation(summary = "获取单个活动状态详情", description = "根据给定的event_id获取具体的活动状态详情。")
    @GetMapping("/activityStateList/{event_id}")
    public Response<ActivityState> getActivityState(
            @Parameter(description = "活动ID", required = true) @PathVariable(name="event_id") Integer eventId) {
        return activityStateService.getActivityState(eventId);
    }

    @Operation(summary = "更新活动状态", description = "更新给定event_id的活动信息。")
    @PutMapping("/activityStateList/{event_id}")
    public Response<String> updateActivityState(
            @Parameter(description = "活动ID", required = true) @PathVariable(name="event_id") Integer eventId,
            @RequestBody ActivityState updatedActivityStaet) {
        return activityStateService.updateActivityState(eventId, updatedActivityStaet);
    }
    @Operation(summary = "删除活动状态", description = "根据给定的event_id删除具体的活动状态详情。")
    @DeleteMapping("/activityStateList/{event_id}")
    public Response<String> deleteActivityState(
            @Parameter(description = "活动ID", required = true) @PathVariable(name="event_id") Integer eventId) {
        return activityStateService.deleteActivityState(eventId);
    }

}

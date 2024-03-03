package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.model.ActivityState;
import com.tencent.wxcloudrun.model.Response;
import com.tencent.wxcloudrun.service.ActivityStateService;
import org.springframework.beans.factory.annotation.Autowired;
import com.tencent.wxcloudrun.dao.ActivityStateMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ActivityStateServiceImpl implements ActivityStateService {
    @Autowired
    private ActivityStateMapper activityStateMapper;

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public Response<ActivityState> getActivityState(Integer actID) {
        ActivityState resActivityState = activityStateMapper.getActivityState(actID);
        if (resActivityState == null) return new Response<>();
        return new Response<>(resActivityState);
    }

    @Override
    public Response<String> updateActivityState(Integer id, ActivityState activityState) {
        return null;
    }

    @Override
    public Response<String> deleteActivityState(Integer id) {
        return null;
    }
}

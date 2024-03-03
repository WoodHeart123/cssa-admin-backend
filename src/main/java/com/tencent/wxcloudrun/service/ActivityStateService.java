package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.ActivityState;
import com.tencent.wxcloudrun.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ActivityStateService {
    /**
     * 根据给定id返回相应活动状态详情
     * @param id 活动状态id
     * @return 单个活动状态
     */
    Response<ActivityState> getActivityState(Integer id);

    /**
     * 根据给定id更新相应活动状态内容
     * @param id 活动状态id
     * @param activityState 新的活动状态
     * @return ”活动状态更新成功“表示更新成功
     */
    Response<String> updateActivityState(Integer id, ActivityState activityState);

    /**
     * 根据给定id删除相应活动状态
     * @param id 活动状态id
     * @return ”活动状态删除成功“表示删除成功
     */
    Response<String> deleteActivityState(Integer id);
}

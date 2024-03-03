package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.ActivityState;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ActivityStateMapper {

    ActivityState getActivityState(Integer actID);

    void updateActivityState(@Param("actID") Integer actID, @Param("activity") ActivityState activityState);

    void deleteActivityState(@Param("actID") Integer actID);
}

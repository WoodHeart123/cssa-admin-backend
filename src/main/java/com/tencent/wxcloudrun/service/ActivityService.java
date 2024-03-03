package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Activity;
import com.tencent.wxcloudrun.model.Response;
import com.tencent.wxcloudrun.model.SignupInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {

    /**
     * check whether user has signed up for the activity
     *
     * @return
     */
    Response<SignupInfo> checkSignup(String userID, Integer actID);

    Response<List<Activity>> getActivityList();

    Response<Object> registerActivity(SignupInfo signupInfo);

    Response<Object> cancelRegister(String userID, Integer actID);

    /**
     * @param userID open id
     * @return a list of activity user registered
     */
    Response<List<Activity>> getRegisterList(String userID);

    /**
     * Get each piece of information of an activity.
     * @param actID an id of an activity to search
     * @return an activity containing details.
     */
    Response<Activity> getActivityDetails(Integer actID);

    /**
     * Get details of all ongoing activities.
     * @return a list containing details of all ongoing activities.
     */
    Response<List<Activity>> getOngoingActivities();

    /**
     * Update each piece of information of a soft-deleted activity; if there is no update for a piece of information,
     * use the old value of that activity. Then make restore the activity.
     * @param actID an id of a soft-deleted activity to search.
     * @param updatedActivity an activity with updated details.
     * @return a string indicating that activity is successfully updated.
     */
    Response<String> updateFullActivity(Integer actID, Activity updatedActivity);

    /**
     * Soft-delete an activity.
     * @param actID an id of an activity to soft-delete.
     * @return a string indicating that activity is successfully soft-deleted.
     */
    Response<String> deleteActivity(Integer actID);
}

package com.tencent.wxcloudrun.model;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
public class ActivityState {
    @Schema(description = "活动状态ID，与对应活动id相同", example = "1")
    @JSONField(name = "activity_id")
    private Integer activity_id;

    @Schema(description = "活动标题，与对应活动标题相同",example = "万圣节")
    private String title;

    @Schema(description = "活动开始时间",example = "2020-12-31 23:59:59")
    @JSONField(name = "start_time")
    private Timestamp startTime;

    @Schema(description = "活动结束时间",example = "2020-12-31 23:59:59")
    @JSONField(name = "end_time")
    private Timestamp endTime;

    @Schema(description = "活动报名截止时间",example = "2020-12-31 23:59:59")
    @JSONField(name = "deadline")
    private Timestamp deadline;

    @Schema(description = "活动删除时间；如果是null则为未删除",example = "2020-12-31 23:59:59")
    @JSONField(name = "deleted_at")
    private Timestamp deletedAt;

    @Schema(description = "活动发布时间；如果是null则为未删除",example = "2020-12-31 23:59:59")
    @JSONField(name = "published_at")
    private Timestamp publishedAt;

    @Schema(description = "活动状态上次更新时间",example = "2020-12-31 23:59:59")
    @JSONField(name = "last_updated")
    private Timestamp lastUpdated;

    @Schema(description = "活动举办地点", example = "Union South")
    private String location;

    // 数据库存储JSON, 无需对外暴露
    @Schema(description = "活动所有文宣", hidden = true)
    @JSONField(name = "announcement")
    private String announcement;

    @Schema(description = "活动报名费用")
    private Integer fee;

    @Schema(description = "活动人数上限")
    private Integer capacity_limit;

    @Schema(description = "活动描述")
    private String description;

    @Schema(description = "活动负责人员")
    @JSONField(name = "responsible_person")
    private String responsible_person;

    @Schema(description = "活动更新日志")
    @JSONField(name = "update_log")
    private String update_log;
}

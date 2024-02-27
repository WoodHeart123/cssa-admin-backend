package org.cssa.admin.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.cssa.admin.service.ActivityService;
import org.cssa.admin.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping({"/activity"})
@Tag(name = "活动中心")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @Autowired
    ContactService contactService;


}

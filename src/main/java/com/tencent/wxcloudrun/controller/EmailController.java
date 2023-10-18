package com.tencent.wxcloudrun.controller;


import com.tencent.wxcloudrun.model.Admin;
import com.tencent.wxcloudrun.model.EmailDetail;
import com.tencent.wxcloudrun.model.Response;
import com.tencent.wxcloudrun.model.ReturnCode;
import com.tencent.wxcloudrun.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@CrossOrigin
@RequestMapping({"/email"})
@Api(tags = "邮件中心")
public class EmailController {

    @Autowired
    EmailService emailService;

    @RequestMapping(value = {"/send"}, method = {RequestMethod.POST})
    @Operation(summary = "发送邮件", description = "发送邮件")
    public Response<Object> send(@Parameter(description = "邮件信息") @RequestBody EmailDetail emailDetail) {
        try{
            return emailService.sendSimpleMail(emailDetail);
        }catch (MessagingException e){
            return new Response<>(ReturnCode.EMAIL_SENT_FAILED);
        }


    }
}

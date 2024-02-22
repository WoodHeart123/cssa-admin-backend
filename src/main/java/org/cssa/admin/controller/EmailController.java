package org.cssa.admin.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import org.cssa.admin.model.EmailDetail;
import org.cssa.admin.model.Response;
import org.cssa.admin.model.ReturnCode;
import org.cssa.admin.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping({"/email"})
@Tag(name = "邮件中心")
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

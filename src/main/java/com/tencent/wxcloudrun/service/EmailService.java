package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.EmailDetail;
import com.tencent.wxcloudrun.model.Response;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface EmailService {

    Response<Object> sendSimpleMail(EmailDetail emailDetail) throws MessagingException;
}

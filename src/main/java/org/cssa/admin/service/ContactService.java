package org.cssa.admin.service;

import jakarta.mail.MessagingException;
import org.cssa.admin.model.EmailDetail;
import org.cssa.admin.model.Response;
import org.cssa.admin.model.SMSDetail;
import org.springframework.stereotype.Service;

@Service
public interface ContactService {

    Response<Object> sendSimpleMail(EmailDetail emailDetail) throws MessagingException;

    Response<Object> sendSimpleText(SMSDetail smsDetail);
}

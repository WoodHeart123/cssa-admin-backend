package org.cssa.admin.service;

import jakarta.mail.MessagingException;
import org.cssa.admin.model.EmailDetail;
import org.cssa.admin.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    Response<Object> sendSimpleMail(EmailDetail emailDetail) throws MessagingException;
}

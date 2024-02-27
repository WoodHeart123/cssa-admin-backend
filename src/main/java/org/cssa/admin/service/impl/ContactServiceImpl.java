package org.cssa.admin.service.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.apache.logging.log4j.util.Strings;
import org.cssa.admin.model.EmailDetail;
import org.cssa.admin.model.Response;
import org.cssa.admin.model.ReturnCode;
import org.cssa.admin.model.SMSDetail;
import org.cssa.admin.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class ContactServiceImpl implements ContactService {

    private final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public Response<Object> sendSimpleMail(EmailDetail emailDetail) throws MessagingException {
        logger.info("sending email to " + emailDetail.getReceiver());
        MimeMessage mailMessage = mailSender.createMimeMessage();
        MimeMessageHelper mailMessageHelper = new MimeMessageHelper(mailMessage, true);
        mailMessageHelper.setFrom(sender);
        mailMessageHelper.setTo(InternetAddress.parse(Strings.join(emailDetail.getReceiver(), ',')));
        mailMessageHelper.setSubject(emailDetail.getSubject());
        mailMessageHelper.setText(emailDetail.getMessage(), true);
        mailSender.send(mailMessage);
        return new Response<>(ReturnCode.SUCCESS);
    }

    @Override
    public Response<Object> sendSimpleText(SMSDetail smsDetail) {
        return null;
    }
}

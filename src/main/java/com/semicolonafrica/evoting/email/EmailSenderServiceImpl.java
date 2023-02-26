package com.semicolonafrica.evoting.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements EmailSenderService{

    JavaMailSender javaMailSender;

    public EmailSenderServiceImpl(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void send(String toEmail, String emailStructure) throws MessagingException {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMessageHelper.setTo(toEmail);
            mimeMessageHelper.setFrom("e-voting@gmail.com");
            mimeMessageHelper.setSubject("Token from e-voting");
            mimeMessageHelper.setText(emailStructure, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (MailException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.KST.TheNetwork.service;

import com.KST.TheNetwork.model.Email;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;
    private final MailContentBuilder mailContentBuilder;

    @Async
    public void sendEmail(Email email){
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("testing@private.com");
            messageHelper.setTo(email.getTo());
            messageHelper.setSubject(email.getSubject());
            System.out.println(mailContentBuilder.build(email.getBody()));
            messageHelper.setText(mailContentBuilder.build(email.getBody()));
        };

        mailSender.send(messagePreparator);
        System.out.println("Message has been sent to the user");
    };
}

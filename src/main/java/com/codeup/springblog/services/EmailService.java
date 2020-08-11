/*
package com.codeup.springblog.services;


import com.codeup.springblog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {

    @Autowired
//    this automatically allows spring to configure stuff in the background ???
    public JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    public String from;


    public void prepareAndSend(Post post, String subject, String body){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(post.getAuthor().getEmail());
        msg.setSubject(subject);
        msg.setText(body);

        try{
            this.emailSender.send(msg);
        } catch(MailException ex){
        //log on here...?
            System.out.println(ex.getMessage());
        }


    }

}
*/

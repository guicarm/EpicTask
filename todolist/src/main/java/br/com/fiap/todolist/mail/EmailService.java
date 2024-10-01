package br.com.fiap.todolist.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;

@Service
public class EmailService {

    @Autowired
    JavaMailSender mailSender;
    
    public void sendEmail(String message) throws MessagingException{

        var email = mailSender.createMimeMessage();
        var helper = new MimeMessageHelper(email);

        helper.setTo("gui@gmail.com");
        helper.setSubject("Nova Tarefa");
        helper.setText("""
                <h1>Nova tarefa cadastrada</h1>
                <p>%s</p>
                """.formatted(message), true);

        mailSender.send(email);
    }
}

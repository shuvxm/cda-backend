package org.jsp.cda.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    JavaMailSender javaMailSender()
    {
        JavaMailSenderImpl jmsi = new JavaMailSenderImpl();

        jmsi.setHost("smtp.gmail.com");
        jmsi.setPort(587);
        jmsi.setUsername("kumarshubham5559@gmail.com");
        jmsi.setPassword("wpoe zlep axqm fres");

        Properties props = jmsi.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return jmsi;
    }
}
package org.jsp.cda.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class Helper {
    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendMail(String email) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(email);
            helper.setSubject("Account Created");
            String htmlContent = "<html> <body> <h1 style='margin:auto; '>"+ email
                    + " Account Created...  Your OTP : "+generateOTP()+" </h1> </body> </html>";
            helper.setText(htmlContent, true);
        } catch (MessagingException e) {
            System.out.println("Invalid Email Id");
            return false;
        }
        try {
            javaMailSender.send(mimeMessage);
        } catch (MailException e) {
            System.out.println("Invalid Email Id");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public int generateOTP() {
        double otp = 0;
        while (otp < 1000) {
            otp = Math.random() * 10000;
        }
        return (int) otp;
    }


}
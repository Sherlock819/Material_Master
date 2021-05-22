package com.example.demo.service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserVerification;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.UserVerificationRepo;

@Service
public class User {

	@Autowired
	UserRepo alRepo;
	
	@Autowired
	UserVerificationRepo userVerificationRepo;
     
    @Autowired
    private JavaMailSender mailSender;
	
	public UserEntity addUser(UserEntity alien)
	{
		if(alien!=null)
		{
			return alRepo.save(alien);
		}
		return null;
	}
	
	public int getAccessCode()
	{
		double r = (Math.random()) * (999999 - 100000 + 1) + 100000;
		int randomCode = (int)r;
		System.out.println("Generated code : "+randomCode);
		return randomCode;
	}
	
	public void sendVerificationEmail(UserVerification user)
	{
		try
		{
	    String toAddress = user.getEmail();
	    String fromAddress = "unorthodox819@gmail.com";
	    String senderName = "BCCL";
	    String subject = "Please verify your registration";
	    String content = "Dear User,<br>"
	            + "Please enter below given access code to verify your registration:<br>"
	            + "<h3>\"[[code]]\"</h3>"
	            + "Thank you,<br>"
	            + "BCCL Material Manager.";
	     
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	     
	    helper.setFrom(fromAddress, senderName);
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	    
	     
	    content = content.replace("[[code]]", user.getVerificationCode()+"");
	     
	    helper.setText(content, true);
	     
	    mailSender.send(message);
	    
		}
		catch(MessagingException e)
		{
			System.out.println(e);
		}
		catch(UnsupportedEncodingException e)
		{
			System.out.println(e);
		}
	}
	
}

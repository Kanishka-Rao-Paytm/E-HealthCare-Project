//package com.paytm.learnwebapp.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//import com.paytm.learnwebapp.model.Email;
//
//@Service
//public class EmailService {
//
//	@Autowired
//	private JavaMailSender javaMailSender;
//	
//	@Value("${email.address}")
//	private String attchEmailAddr;
//	
//	public void sendTextNotf(Email email)
//	{
//		SimpleMailMessage msg = new SimpleMailMessage();
//		try {
//			msg.setTo(email.getSendTo());
//			msg.setSubject(email.getSubject());
//			msg.setText(email.getBody());
//			javaMailSender.send(msg);
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		
//	}
//}

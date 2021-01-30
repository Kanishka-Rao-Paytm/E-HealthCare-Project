package com.paytm.learnwebapp.controller;

import java.io.IOException; 
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.paytm.learnwebapp.model.Email;
import com.paytm.learnwebapp.model.User;
//import com.paytm.learnwebapp.service.EmailService;
//import com.paytm.learnwebapp.service.UserService;
import com.paytm.learnwebapp.service.UserService;

import jdk.internal.org.jline.utils.Log;

@SuppressWarnings("unused")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(value = "/")
	@ResponseBody
	public String homepage()
	{
		String s="<br><br><center><h2>Welcome Home!</h3></center><br><h4><a href=\"localhost:8080/addProfile\">Add Profile</a></h4>";
		s=s+"<h4><a href=\"localhost:8080/updateProfile\">Update Profile</a></h4>";
		s=s+"<h4><a href=\"localhost:8080/deleteProfile\">Delete Profile</a></h4>";
		s=s+"<h4><a href=\"localhost:8080/getAll\">Show all profiles</a></h4>";
		s=s+"<h4><a href=\"localhost:8080/getById\">Search By Id</a></h4>";
		s=s+"<h4><a href=\"localhost:8080/getByJob\">Search By Job</a></h4>";
		s=s+"<h4><a href=\"localhost:8080/getEmail\">Get User's Email</a></h4>";
		s=s+"<br><h4><a href=\"localhost:8080/sendNotification\">Send Notification via Email</a></h4>";
		return s;
	}
	
	@GetMapping(value = "/getAll")
	@ResponseBody
	public List<String> getAll()
	{
		logger.trace("In the getAll function");
		return userService.fetchAll();
	}
	
	@GetMapping(value = "/getById")
	@ResponseBody
	public String getById()
	{
		logger.trace("In the getById function");
		String s="<html><head></head><body><h3>Search User By Id</h2>"
				+"<form action=\"findByIdNext\">"
				+ "Id : <input id=\"id\" name=\"id\"/><br>"
				+ "<input type=\"submit\" value=\"Search\"/>"
				+ "</form>"
				+ "</body></html>";
		return s;
	}
	@GetMapping(value = "/findByIdNext")
	@ResponseBody
	public String findProfileById(String id)
	{
		return userService.fetchById(id);	
	}
	
	@GetMapping(value = "/getByJob")
	@ResponseBody
	public String getByProfile()
	{
		logger.trace("In the getByJob function");
		String s="<html><head></head><body><h3>Search User By Job-Role</h2>"
				+"<form action=\"findByJobNext\">"
				+ "Jobrole : <input id=\"jobrole\" name=\"jobrole\"/><br>"
				+ "<input type=\"submit\" value=\"Search\"/>"
				+ "</form>"
				+ "</body></html>";
		return s;
		
	}
	@GetMapping(value = "/findByJobNext")
	@ResponseBody
	public List<String> findbyProfile(String jobrole)
	{
		return userService.fetchByProfile(jobrole);
	}
	
	@GetMapping(value = "/addProfile")
	@ResponseBody
	public String add()
	{
		logger.trace("In the addProfile function");
		String s="<html><head></head><body><h3>User Registration</h2>"
				+"<form action=\"adddata\">"
				+ "Id : <input id=\"id\" name=\"id\"/><br>"
				+ "Name : <input id=\"name\" name=\"name\"/><br>"
				+ "Job Role : <input id=\"jobrole\" name=\"jobrole\"/><br>"
				+ "Email : <input id=\"email\" name=\"email\"/><br>"
				+ "Phone : <input id=\"phone\" name=\"phone\"/><br>"
				+ "<input type=\"submit\" value=\"Register\"/>"
				+ "</form>"
				+ "</body></html>";
		return s;
		
	}
	@GetMapping(value = "/adddata")
	@ResponseBody
	public String addProfileNext(User user)
	{
		return userService.addProfile(user);
	}
	
	@GetMapping(value = "/updateProfile")
	@ResponseBody
	public String update()
	{
		logger.trace("In the updateProfile function");
		String s="<html><head></head><body><h3>Update User Information</h2>"
				+"<form action=\"updatedata\">"
				+ "Id : <input id=\"id\" name=\"id\"/><br>"
				+ "Name : <input id=\"name\" name=\"name\"/><br>"
				+ "Job Role : <input id=\"jobrole\" name=\"jobrole\"/><br>"
				+ "Email : <input id=\"email\" name=\"email\"/><br>"
				+ "Phone : <input id=\"phone\" name=\"phone\"/><br>"
				+ "<input type=\"submit\" value=\"Update\"/>"
				+ "</form>"
				+ "</body></html>";
		return s;
	}
	@GetMapping(value = "/updatedata")
	@ResponseBody
	public String updateProfileNext(User user)
	{
		return userService.editProfile(user, user.getId());
	}
	
	@GetMapping(value = "/deleteProfile")
	@ResponseBody
	public String delete()
	{
		logger.trace("In the deleteProfile function");
		String s="<html><head></head><body><h3>Delete User</h2>"
				+"<form action=\"deletedata\">"
				+ "Id : <input id=\"id\" name=\"id\"/><br>"
				+ "<input type=\"submit\" value=\"Delete\"/>"
				+ "</form>"
				+ "</body></html>";
		return s;
		
	}
	@GetMapping(value = "/deletedata")
	@ResponseBody
	public String deleteProfileNext(String id)
	{
		return userService.deleteProfile(id);	
	}
	
	@GetMapping(value = "/getEmail")
	@ResponseBody
	public String getEmail()
	{
		logger.trace("In the getEmail function");
		String s="<html><head></head><body><h3>Search User's Email</h2>"
				+"<form action=\"getemailbyid\">"
				+ "Id : <input id=\"id\" name=\"id\"/><br>"
				+ "<input type=\"submit\" value=\"Search\"/>"
				+ "</form>"
				+ "</body></html>";
		return s;
		
	}
	@GetMapping(value = "/getemailbyid")
	@ResponseBody
	public String getEmailById(String id)
	{
		return userService.fetchEmail(id);	
	}
	
//	@Autowired
//	private EmailService emailService;
//	
//	@PostMapping(value="/sendnotification", consumes = "application/json", produces="application/json")
//	@ResponseBody
//	public String sendEmail(@RequestBody Email email)
//	{
//		try {
//			Log.info("Sending Notification..");
//			emailService.sendTextNotf(email);
//			return "Notification Sent!";
//		}catch(Exception ex)
//		{
//			return "Error in sending notification.";
//		}
//	}
	
//	@RequestMapping(value="sendNotification/{id}")
//	public String sendEmail(@PathVariable int id) throws AddressException, MessagingException, IOException
//	{
//		String mailid=userService.getEmail(id);
//		sendmail(mailid);
//		return "Email sent successfully!";
//	}
//	
//	private void sendmail(String mailid) throws AddressException, MessagingException, IOException {
//		   Properties props = new Properties();
//		   props.put("mail.smtp.auth", "true");
//		   props.put("mail.smtp.starttls.enable", "true");
//		   props.put("mail.smtp.host", "smtp.gmail.com");
//		   props.put("mail.smtp.port", "587");
//		   
//		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//		      protected PasswordAuthentication getPasswordAuthentication() {
//		         return new PasswordAuthentication("fabfamfun5@gmail.com", "31081997kanishka,..");
//		      }
//		   });
//		   Message msg = new MimeMessage(session);
//		   msg.setFrom(new InternetAddress("fabfamfun5@gmail.com", false));
//
//		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("fabfamfun5@gmail.com"));
//		   msg.setSubject("Check");
//		   msg.setContent("Hello There !", "text/html");
//		   msg.setSentDate(new Date());
//
//		   MimeBodyPart messageBodyPart = new MimeBodyPart();
//		   messageBodyPart.setContent("Hey check it out!", "text/html");
//
//		   Multipart multipart = new MimeMultipart();
//		   multipart.addBodyPart(messageBodyPart);
////		   MimeBodyPart attachPart = new MimeBodyPart();
////		   attachPart.attachFile("/var/tmp/image19.png");
////		   multipart.addBodyPart(attachPart);
//		   msg.setContent(multipart);
//		   Transport.send(msg);   
//		}
	
//	
//	@RequestMapping(value = "/usertrial", method = RequestMethod.GET)
//	@ResponseBody
//	public List<TrialUser> getAll()
//	{
//		return userService.printAll();	
//		//return "<br><br><center><h3>Welcome here..!</h3></center>";
//	}
//	
//	@RequestMapping(value = "/usertrial/{id}")
//	public TrialUser getById(@PathVariable String id)
//	{
//		TrialUser t = userService.getUser(id);
//		return t;
//	}
//	
//	@RequestMapping(value = "/usertrial/add", method = RequestMethod.POST)
//	public String add(@RequestBody TrialUser userTest)
//	{
//		return userService.addUser(userTest);
//	}
//	
//	@RequestMapping(value = "/usertrial/update/{id}", method = RequestMethod.PUT)
//	public String update(@RequestBody TrialUser userTest, @PathVariable String id)
//	{
//		return userService.updateById(id, userTest);
//	}
//	
//	@RequestMapping(value = "/usertrial/delete/{id}", method = RequestMethod.DELETE)
//	public String deleteUser(@PathVariable String id)
//	{
//		return userService.deleteById(id);
//	}
//	
}

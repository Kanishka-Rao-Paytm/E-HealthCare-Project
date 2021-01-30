package com.paytm.learnwebapp.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paytm.learnwebapp.dao.UserDao;
import com.paytm.learnwebapp.model.User;

@Service
public class UserService
{	
	public String addProfile(User user) 
	{
		UserDao dao = new UserDao();
		int rs = dao.Insert(user);
		if(rs==0)
			return "Error Occurred.";
		else
			return "OK. 1 row(s) inserted.";
	}
	public String editProfile(User user, String id)
	{
		UserDao dao = new UserDao();
		int rs = dao.Update(user, id);
		if(rs==0)
			return "Error Occurred.";
		else
			return "OK. 1 row(s) updated.";
		
	}
	public List<String> fetchAll()
	{
		UserDao dao = new UserDao();
		List<String> result = dao.SelectAll();
		return result;
	}
	public List<String> fetchByProfile(String jobrole) 
	{
		UserDao dao = new UserDao();
		List<String> result = dao.SelectByJob(jobrole);
		return result;
	}
	public String fetchById(String id) 
	{
		UserDao dao = new UserDao();
		String result = dao.SelectById(id);
		if (result=="Not found.")
			return "User Not Found.";
		else
			return result;
	}
	public String deleteProfile(String id) {
		UserDao dao = new UserDao();
		int rs = dao.Delete(id);
		if(rs==0)
			return "Error Occurred.";
		else
			return "OK. 1 row(s) deleted.";
	}
	public String fetchEmail(String id) {
		UserDao dao = new UserDao();
		String rs = dao.findEmail(id);
		if (rs=="Not found.")
			return "User Not Found.";
		else
			return rs;
	}
}

//
//import java.util.ArrayList; 
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.paytm.learnwebapp.model.TrialUser;
//import com.paytm.learnwebapp.repository.TrialUserRepo;
//
//@Service
//public class UserService {
//
//	@Autowired
//	private TrialUserRepo trialUserRepo;
//	
//	private List<TrialUser> users = new ArrayList<>(Arrays.asList(
//			new TrialUser("0001", "us1", "pas1", "7462849", "us1@ps1"),
//			new TrialUser("0002", "us2", "pas2", "9526534", "us2@ps2"),
//			new TrialUser("0003", "us3", "pas3", "4354324", "us3@ps3")
//			));
//	
//	public List<TrialUser> printAll() {
//		List<TrialUser> usertest=new ArrayList<>();
//		trialUserRepo.findAll().forEach(usertest::add);
//		return usertest;
//	}
//	
//	public TrialUser getUser(String id)
//	{
//		return users.stream().filter(u -> u.getId().equals(id)).findFirst().get();
//	}
//	
//	public String addUser(TrialUser userTest) {
//		trialUserRepo.save(userTest);
//		return "1 row inserted.";
//		
//	}
//	
//	public String updateById(String id, TrialUser userTest) {
//		for(int i=0;i<users.size();i++)
//		{
//			TrialUser t = users.get(i);
//			if(t.getId()==id)
//			{
//				users.set(i, userTest);
//				return "1 row updated.";
//			}
//		}
//		return "Did not work";
//	}
//	
//	public String deleteById(String id) {
//		for(int i=0;i<users.size();i++)
//		{
//			TrialUser t = users.get(i);
//			if(t.getId()==id)
//			{
//				users.remove(t);
//				return "1 row deleted.";
//			}
//		}
//		return "Did not work";
//	}
//	
//}

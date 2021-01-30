//package com.paytm.learnwebapp.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Required;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.paytm.learnwebapp.model.User;
//import com.paytm.learnwebapp.model.UserDetailsImpl;
//import com.paytm.learnwebapp.repository.TrialUserRepo;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService{
//
//	@Autowired
//	private TrialUserRepo userrepo;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//		
//		User user=userrepo.findByUsername(username);
//		if(user==null)
//			throw new UsernameNotFoundException("User Not Found!");
//		
//		return new UserDetailsImpl(user);
//	}
//}

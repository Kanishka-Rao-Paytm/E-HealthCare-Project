//package com.paytm.learnwebapp.controller;
//
//import javax.validation.Valid;
//
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import com.paytm.learnwebapp.model.User;
//
//@RestController
//public class WebController implements WebMvcConfigurer {
//
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/enterdetails").setViewName("enterdetails");
//	}
//
//	@GetMapping("/")
//	public String showForm(User user) {
//		return "form";
//	}
//
//	@PostMapping("/")
//	public String checkPersonInfo(@Valid User user, BindingResult bindingResult) {
//
//		if (bindingResult.hasErrors()) {
//			return "form";
//		}
//
//		return "redirect:/results";
//	}
//}

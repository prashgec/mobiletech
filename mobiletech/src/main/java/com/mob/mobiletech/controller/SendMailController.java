package com.mob.mobiletech.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mob.mobiletech.domain.User;
import com.mob.mobiletech.services.MailMail;

//	import com.mob.service.ApplicationMailer1;

	/**
	 * @author Sushil
	 *
	 */
	@Controller
	@RequestMapping(value ="/SendMail")
	public class SendMailController {
		@Autowired
		//private MailSender mailSender;
		private MailMail mailMail;
		public void setMailMail(MailMail mailMail) {
			this.mailMail = mailMail;
		}
		@RequestMapping(method = RequestMethod.POST)
		public ModelAndView sendEmail(HttpServletRequest request) {
		  
			
	        String text="Name: " + request.getParameter("name") + "\n" +"Contact: " +request.getParameter("contact")+
	        		     "\nEmail: " + request.getParameter("email") + "\nMessage: " + request.getParameter("message");
			
	        mailMail.sendMail("mobiletech@gmail.com",
	    		   "admin@mobiletech.co.in",
	    		   "Enquiry On MobileTech", 
	    		   text);
			
	   		return new ModelAndView("enquiry","loginForm",new User());
		}


	}
	


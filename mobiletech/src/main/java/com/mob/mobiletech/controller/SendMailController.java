/*package com.mob.mobiletech.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mob.mobiletech.domain.User;

//	import com.mob.service.ApplicationMailer1;

	*//**
	 * @author Sushil
	 *
	 *//*
	@Controller
	@RequestMapping("/SendMail")
	public class SendMailController {
	//	@Autowired
			private JavaMailSenderImpl mailSender;
		@RequestMapping(method = RequestMethod.POST)
		public ModelAndView sendEmail(HttpServletRequest request) {
			SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo("kuldeepkuldeepjain@yahoo.co.in");
	        message.setSubject("Regarding MobileTech Enquiry");
	        String text="Name: " + request.getParameter("name") + "\n" +"Contact: " +request.getParameter("contact")+
	        		     "\nEmail: " + request.getParameter("email") + "\nMessage: " + request.getParameter("message");
	        message.setText(text);
	        System.out.println("Text : " + text);
	        System.out.println("TO " + message.getTo()[0] + "Subject " + message.getSubject());
	        if(mailSender == null)
	        	System.out.println("can't send the mail");
	        else {
	            mailSender.send(message);
	        }
			//Create the application context
	      //  ApplicationContext context = new FileSystemXmlApplicationContext("WebContent/WEB-INF/spring-servlet.xml");
	         
	        //Get the mailer instance
	        //ApplicationMailer mailer = new ApplicationMailer();//(ApplicationMailer) context.getBean("mailService");
	 
	        //Send a composed mail
	        //mailer.sendMail("Sushiltilak00@gmail.com", "Test Subject", "Testing body");
			
			
			
			String message1 = "Enquiry Submitted... You may get a call soon.";
			return new ModelAndView("enquirySuccess", "message", message1);
		}


	}
	

*/
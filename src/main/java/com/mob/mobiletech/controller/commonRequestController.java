package com.mob.mobiletech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mob.mobiletech.domain.User;

@Controller
public class commonRequestController {
	@RequestMapping(value ="/commonRequestLoad")
	public @ResponseBody ModelAndView commonRequestLoad(@RequestParam("info") String info, ModelMap model) {
		//model.addAttribute("menu", info);
		//System.out.println("page is :" + info);
		return new ModelAndView(info,"loginForm",new User());
	}
	
}

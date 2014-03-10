/**
 * 
 */
package com.mob.mobiletech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mob.mobiletech.domain.User;

/**
 * @author Prashant
 *
 */
@Controller
public class BaseController {
	
	 @RequestMapping(value = "/student", method = RequestMethod.GET)
	   public ModelAndView student() {
	      return new ModelAndView("student", "command", new User());
	   }
	   
	   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	   public ModelAndView addStudent(@ModelAttribute("SpringWeb")User student, 
	   ModelMap model) {
	      model.addAttribute("name", student.getFirstName());
	      model.addAttribute("age", student.getDob());
	      model.addAttribute("id", student.getUserId());
	      
	      return new ModelAndView("result", "command", student);
	   }

}

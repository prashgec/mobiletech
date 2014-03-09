/**
 * 
 */
package com.mob.mobiletech.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;





/**
 * @author Prashant
 *
 */
@Controller
public class MainPageController extends SimpleFormController {
	
	public MainPageController()
	{
		//setCommandClass(Login.class);
		//setCommandName("login");
	}

	/*@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {

		//Login login =(Login)request.getAttribute("login");
		System.out.println("Username");
		return new Login();
	}*/
	
	/*@RequestMapping(value="/viewDistributor", method = RequestMethod.GET)
	public ModelAndView viewDistributor(@RequestParam("userid") int userid,HttpServletRequest request)
	{
		Admin admin=(Admin)request.getSession().getAttribute("user");
		ModelAndView model = new ModelAndView("main");
		model.addObject("distributors", new ArrayList<Distributor>(admin.getDistributors()));
		
			return model;
		
	}*/
}

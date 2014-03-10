package com.mob.mobiletech.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;








import com.mob.mobiletech.constants.Constants;
import com.mob.mobiletech.domain.TransactionRequest;
import com.mob.mobiletech.domain.User;
import com.mob.mobiletech.model.LoginValidation;
import com.mob.mobiletech.util.CommonUtils;



@Controller
public class HomePageController  {
	static final Logger logger = Logger.getLogger(HomePageController.class);

	@Autowired
	LoginValidation loginValidation;
	
	
	/*public HomePageController()
	{
		//System.out.println(LogManager.getRootLogger().set);
		PropertyConfigurator.configure(Constants.LOG_FILE_PATH);
		logger.info( System.getProperty("com.sun.management.jmxremote.port")+"Home Page INIT successfully info Logger Name"+ logger.getName());
		logger.debug("Home Page INIT successfully debug Logger Name"+ logger.getName());
		setCommandClass(Login.class);
		setCommandName("loginForm");
	}*/
	

	

	
	/**
	 * @return the loginValidation
	 */
	public LoginValidation getLoginValidation() {
		return loginValidation;
	}





	/**
	 * @param loginValidation the loginValidation to set
	 */
	public void setLoginValidation(LoginValidation loginValidation) {
		this.loginValidation = loginValidation;
	}





	@RequestMapping(value = "/loginLoad", method = RequestMethod.GET)
	public ModelAndView loginLoad()
	{
	
	return new ModelAndView("header","loginForm",new User());
	}





	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	@RequestMapping(value = "/loginSubmit", method = RequestMethod.POST)
	public ModelAndView loginSubmit(@ModelAttribute("SpringWeb")User user,HttpServletRequest request,ModelMap model) 
	{
		user=loginValidation.validate(user.getUserName(), user.getPassword());
		if(user!=null){
			user.setLastLogin(CommonUtils.getSystemDate());
			if(Constants.ROLE_ADMIN==user.getRole())
			{
				try{
				Float tempBal=Float.parseFloat(CommonUtils.getJoloBalance());
				user.setAvailableBalance(tempBal);
				}
				catch (Exception e) {
					logger.info("Exception in balance Updation from JOLO URL",e);

				}
			}
			//List<Object> notificationlst=new ArrayList<Object>();
			loginValidation.getBaseDAO().saveOrUpdate(user);
			//notificationlst=loginValidation.getBaseDAO().fetchAll(user.getUserId(), "requestedTo", TransactionRequest.class.getName());
			//request.getSession().setAttribute("notification", notificationlst.size());
			//request.getSession().setAttribute("notificationlst", notificationlst);
			request.getSession().setAttribute("user", user);
			
			model.addAttribute("access", "read");
			model.addAttribute("menu", "profile");
			
		return new ModelAndView("createUser","user",user);}
		else
		{
			model.addAttribute("error", "001");
			return new ModelAndView("login","loginForm",new User());
		}
			
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) 
	{
		request.getSession().invalidate();
		return new ModelAndView("login","loginForm",new User());
		
	}

	
	@RequestMapping(value = "/viewNotification", method = RequestMethod.GET)
	   public ModelAndView viewNotification(@RequestParam("userid") Integer userid, ModelMap model) {
	     
	      List<Object> reqList= loginValidation.getBaseDAO().fetchAll(userid, "requestedTo", TransactionRequest.class.getName());
	      model.addAttribute("menu", "notification");
	      return new ModelAndView("result", "notflst", reqList);
	   }
	




	
	
}

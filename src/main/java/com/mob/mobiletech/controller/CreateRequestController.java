/**
 * 
 */
package com.mob.mobiletech.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mob.mobiletech.constants.Constants;
import com.mob.mobiletech.dao.BaseDAO;
import com.mob.mobiletech.domain.TransactionRequest;
import com.mob.mobiletech.domain.User;
import com.mob.mobiletech.util.CommonUtils;

/**
 * @author Prashant
 *
 */
@Controller
public class CreateRequestController {
	
	@Autowired
	BaseDAO baseDAO;
	
	
	/**
	 * @return the baseDAO
	 */
	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	/**
	 * @param baseDAO the baseDAO to set
	 */
	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}
	
	@RequestMapping(value = "/createRequestLoad", method = RequestMethod.GET)
	public ModelAndView createUserLoad(ModelMap model, HttpServletRequest request)
	{
	TransactionRequest transactionRequest= new TransactionRequest();
	User userLoggedin= (User)request.getSession().getAttribute("user");
	model.addAttribute("menu", "createrequest");
	model.addAttribute("action","create");
	transactionRequest.setRequestedBy(userLoggedin.getUserId());
	transactionRequest.setRequesterName(userLoggedin.getFirstName()+" "+userLoggedin.getLastName());
	transactionRequest.setRequestedTo(userLoggedin.getPrntId());
	transactionRequest.setCreateDate(CommonUtils.getSystemDate());
	return new ModelAndView("createrequest","tnxrequest",transactionRequest);
	}
	
	
	@RequestMapping(value = "/createRequestSubmit", method = RequestMethod.POST)
	public ModelAndView createRequestSubmit(@ModelAttribute("SpringWeb")TransactionRequest tnxrequest, HttpServletRequest request,ModelMap model) 
	{
		User userLoggedin= (User)request.getSession().getAttribute("user");
		
		baseDAO.saveOrUpdate(tnxrequest);
		
		model.addAttribute("access", "read");
		model.addAttribute("menu", "profile");
		model.addAttribute("message","Your Request No "+tnxrequest.getReqId()+" is submitted successfully and pending for Approval.");
		
		
	return new ModelAndView("createUser","user",userLoggedin);}
	
	@RequestMapping(value = "/viewRequestLoad", method = RequestMethod.GET)
	   public ModelAndView viewRequestLoad(@RequestParam("userid") Integer userid, ModelMap model,HttpServletRequest request) {
		//User userLoggedin= (User)request.getSession().getAttribute("user");
		List<TransactionRequest> notfList= baseDAO.fetchAll(userid, "requestedBy", TransactionRequest.class.getName());
		/*if(userLoggedin.getRole()==0)
		{
			
		}*/
	      
	      model.addAttribute("menu", "viewrequest");
	      return new ModelAndView("result", "notflst", notfList);
	   }
		
	

}

/**
 * 
 */
package com.mob.mobiletech.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mob.mobiletech.dao.BaseDAO;
import com.mob.mobiletech.domain.TransactionRecharge;
import com.mob.mobiletech.domain.TransactionRequest;
import com.mob.mobiletech.domain.User;
import com.mob.mobiletech.util.CommonUtils;

/**
 * @author Prashant
 *
 */
@Controller
public class ViewTransactionController {
	
	@Autowired
	BaseDAO baseDAO;
	
	
	

	public BaseDAO getBaseDAO() {
		return baseDAO;
	}




	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}



	@RequestMapping(value = "/filterTransaction", method = RequestMethod.POST)
	   public ModelAndView filterTransaction(@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate,ModelMap model,HttpServletRequest request) {
		User userLoggedin= (User)request.getSession().getAttribute("user");
		model.addAttribute("menu", "viewtransaction");
		model.addAttribute("txns", CommonUtils.getTransactionHistory(fromDate, toDate));
		return new ModelAndView("filter");
		
		}
	

	@RequestMapping(value = "/viewTnxLoad", method = RequestMethod.GET)
	   public ModelAndView viewTnxLoad(@RequestParam("userid") Integer userid, ModelMap model,HttpServletRequest request) {
		User userLoggedin= (User)request.getSession().getAttribute("user");
		model.addAttribute("menu", "viewtransaction");
		if(userLoggedin.getRole()==0)
		{
			return new ModelAndView("filter");
		}
	      
		else if (userLoggedin.getRole()==1)
				{
			 List<Object> tnxList= baseDAO.fetchAll(userid, "prntId", TransactionRecharge.class.getName());
		      return new ModelAndView("viewtnx", "tnxList", tnxList);
				}
	      List<Object> tnxList= baseDAO.fetchAll(userid, "userId", TransactionRecharge.class.getName());
	      return new ModelAndView("viewtnx", "tnxList", tnxList);
	   }
	   
	
}

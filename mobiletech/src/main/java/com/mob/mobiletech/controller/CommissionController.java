/**
 * 
 */
package com.mob.mobiletech.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mob.mobiletech.dao.BaseDAO;
import com.mob.mobiletech.domain.ReferenceData;
import com.mob.mobiletech.domain.TransactionRequest;
import com.mob.mobiletech.form.CommissionForm;



/**
 * @author Prashant
 *
 */
@Controller
public class CommissionController {
	
	@Autowired
	BaseDAO baseDAO;
	
	
	
	
	public BaseDAO getBaseDAO() {
		return baseDAO;
	}




	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}




	@RequestMapping(value = "/viewCommission", method = RequestMethod.GET)
	public ModelAndView viewCommission(ModelMap model, HttpServletRequest request)
	{
		CommissionForm commissionForm= new CommissionForm();
		List<ReferenceData> tempList= baseDAO.fetchAll(1,null, ReferenceData.class.getName());
		/*for (int i=1;i<=4;i++)
		{
		tempList.add( 
			(List<Object>)baseDAO.fetchAll(i,"dataId", ReferenceData.class.getName()));
		}*/
		
		
		commissionForm.setList(tempList);
		return new ModelAndView("commission","commission",commissionForm);
	}

	@RequestMapping(value ="/saveCommission", method= RequestMethod.POST)
	public ModelAndView saveCommission(@ModelAttribute("commission")CommissionForm commissionForm, ModelMap model, HttpServletRequest request)
	{
		
		baseDAO.saveAll((commissionForm.getList()));
		model.addAttribute("message", "Commission Updated Successfully :)");
		return new ModelAndView("commission","commission",commissionForm);
		
		
	}
}

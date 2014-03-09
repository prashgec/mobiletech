/**
 * 
 */
package com.mob.mobiletech.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mob.mobiletech.constants.Constants;
import com.mob.mobiletech.dao.BaseDAO;
import com.mob.mobiletech.domain.ReferenceData;
import com.mob.mobiletech.domain.TransactionRecharge;
import com.mob.mobiletech.domain.TransactionRequest;
import com.mob.mobiletech.domain.User;
import com.mob.mobiletech.util.CommonUtils;

/**
 * @author Prashant
 *
 */
@Controller
public class LandLineBillPayController implements ServletContextAware{
	
	private ServletContext servletContext;
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}
	
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
	
	
	@RequestMapping(value = "/landLineBillPayLoad", method = RequestMethod.GET)
	public ModelAndView rechargeLoad(ModelMap model, HttpServletRequest request)
	{
	TransactionRecharge transactionRecharge= new TransactionRecharge();
	User userLoggedin= (User)request.getSession().getAttribute("user");
	
	
	Map option= new HashMap<String, String>();
//	option.put("1", "Mobile Recharge");
//	option.put("2", "Data Card");
//	option.put("3", "DTH");
//	option.put("4", "Postpaid Recharge");
	option.put("6", "Landline Bill Pay");
	model.addAttribute("option",option);
	/*model.addAttribute("list1",baseDAO.fetchAll(1, "dataId", ReferenceData.class.getName()));
	model.addAttribute("list2",baseDAO.fetchAll(2, "dataId", ReferenceData.class.getName()));
	model.addAttribute("list3",baseDAO.fetchAll(3, "dataId", ReferenceData.class.getName()));
	model.addAttribute("list4",baseDAO.fetchAll(3, "dataId", ReferenceData.class.getName()));*/
	Gson gson = new Gson();
	
//	model.addAttribute("list1", gson.toJson(baseDAO.fetchAll(1, "dataId", ReferenceData.class.getName())));
//	model.addAttribute("list2", gson.toJson(baseDAO.fetchAll(2, "dataId", ReferenceData.class.getName())));
//	model.addAttribute("list3", gson.toJson(baseDAO.fetchAll(3, "dataId", ReferenceData.class.getName())));
//	model.addAttribute("list4", gson.toJson(baseDAO.fetchAll(4, "dataId", ReferenceData.class.getName())));
	model.addAttribute("list6", gson.toJson(baseDAO.fetchAll(6, "dataId", ReferenceData.class.getName())));
/*	model.addAttribute("list2", gson.toJson(servletContext.getAttribute("2")));
	/*	model.addAttribute("list3", gson.toJson(servletContext.getAttribute("3")));
	model.addAttribute("list4", gson.toJson(servletContext.getAttribute("4"))); */
	model.addAttribute("menu", "landLineBillPay");
	
	
	return new ModelAndView("landLineBillPay","tnxrecharge",transactionRecharge);
	}
	
	@RequestMapping(value = "/landLineBillPaySubmit", method = RequestMethod.POST)
	public ModelAndView createRequestSubmit(@ModelAttribute("SpringWeb")TransactionRecharge tnxrecharge, HttpServletRequest request,ModelMap model) 
	{
		User userLoggedin= (User)request.getSession().getAttribute("user");
		if(tnxrecharge.getTnxAmount()>userLoggedin.getAvailableBalance())
		{
			model.addAttribute("error","003");
			return new ModelAndView("landLineBillPay","tnxrecharge",tnxrecharge);
		}
		tnxrecharge.setUserId(userLoggedin.getUserId());
		tnxrecharge.setPrntId(userLoggedin.getPrntId());
		tnxrecharge.setTnxDate(CommonUtils.getDate());
		
		baseDAO.saveOrUpdate(tnxrecharge);

		Float commission=baseDAO.getCommission(tnxrecharge.getOperator());
	//	userLoggedin.recharge(tnxrecharge.getTnxAmount().floatValue(), commission);
		
		String returnVal=CommonUtils.landLineBillPay(tnxrecharge.getMobNo(), tnxrecharge.getTnxAmount(), tnxrecharge.getTnxId(),tnxrecharge.getOperator(),tnxrecharge.getAccount());
     //	userLoggedin.recharge(tnxrecharge.getTnxAmount().floatValue(), userLoggedin.getCommission());
		//userLoggedin.setAvailableBalance(userLoggedin.getAvailableBalance()-tnxrecharge.getTnxAmount()+(tnxrecharge.getTnxAmount()*userLoggedin.getCommission()/100));
		//userLoggedin.setUsedBalance(userLoggedin.getUsedBalance()+tnxrecharge.getTnxAmount()-(tnxrecharge.getTnxAmount()*userLoggedin.getCommission()/100));
		if(returnVal!=null){
		String strArr[]=returnVal.split(",");
		if (strArr.length < 2){
			returnVal=	"Mob"+tnxrecharge.getTnxId()+",Falied,"+tnxrecharge.getOperator()+","+tnxrecharge.getMobNo()+","+tnxrecharge.getTnxAmount()+",your website orderid,MobileTech under maintainance,Mob"+tnxrecharge.getTnxId();
			strArr=returnVal.split(",");;
		}
		
		tnxrecharge.setTnxRemark(strArr[1]);
		tnxrecharge.setJoloTnxId(strArr[0]);
		/*tnxrecharge.setUserId(userLoggedin.getUserId());
		tnxrecharge.setPrntId(userLoggedin.getPrntId());
		tnxrecharge.setTnxDate(CommonUtils.getDate());*/
		
		
		
		if(Constants.SUCCESS.equalsIgnoreCase(strArr[1])||Constants.PENDING.equalsIgnoreCase(strArr[1]))
			
		{
			userLoggedin.recharge(tnxrecharge.getTnxAmount().floatValue(), commission);
			
			Float tempamt=tnxrecharge.getTnxAmount().floatValue()-((commission*tnxrecharge.getTnxAmount())/100);
			tnxrecharge.setChargedAmount(tempamt);
			tnxrecharge.setTnxStatus(0);
			baseDAO.saveOrUpdate(userLoggedin);
			model.addAttribute("access", "disable");
			request.getSession().setAttribute("user", userLoggedin);
			model.addAttribute("message", "Bill Payment successfull with ref id "+strArr[0]);
		}
		else
		{
			tnxrecharge.setTnxStatus(1);
			model.addAttribute("error", "Bill Payment unsuccessfull with ref id "+strArr[7] +" and error message is "+strArr[6]);
		}
		
		}
		tnxrecharge.setRemainingAmount(userLoggedin.getAvailableBalance());
		baseDAO.saveOrUpdate(tnxrecharge);
		 
		Map option= new HashMap<String, String>();
		option.put("6", "Landline Bill Pay");
/*		option.put("2", "Data Card");
		option.put("3", "DTH");
		option.put("4", "Postpaid Recharge"); */
		model.addAttribute("option",option);
		
		Gson gson = new Gson();
		
		model.addAttribute("list6", gson.toJson(baseDAO.fetchAll(6, "dataId", ReferenceData.class.getName())));
	/*	model.addAttribute("list2", gson.toJson(servletContext.getAttribute("2")));
		model.addAttribute("list3", gson.toJson(servletContext.getAttribute("3")));
		model.addAttribute("list4", gson.toJson(servletContext.getAttribute("4"))); */
		
		//model.addAttribute("access", "read");
		model.addAttribute("menu", "landLineBillPay");
		
		//model.addAttribute("message","Your Request No "+tnxrecharge.getTnxId()+" is submitted successfully and pending for Approval.");
		
		
	return new ModelAndView("landLineBillPay","tnxrecharge",tnxrecharge);}
	
	

}

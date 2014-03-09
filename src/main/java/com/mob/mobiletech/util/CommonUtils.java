/**
 * 
 */
package com.mob.mobiletech.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import org.apache.log4j.Logger;

import com.mob.mobiletech.constants.Constants;
import com.mob.mobiletech.domain.TransactionRecharge;
import com.mob.mobiletech.domain.User;

/**
 * @author Prashant
 *
 */
public class CommonUtils {
	private final static Logger LOGGER = Logger.getLogger(CommonUtils.class);
	
	public static String getSystemDate()
	{
		
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat(
	            "dd/MM/yyyy 'at' hh:mm a");
		sd.setTimeZone(TimeZone.getTimeZone("IST"));
		return sd.format(date);
	}
	
	public static Date getDate()
	{
		
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat(
				
	            "yyyy.MM.dd");
		Calendar cal= Calendar.getInstance(new SimpleTimeZone(28800000,"IST"));
		//sd.setTimeZone(TimeZone.getTimeZone(""));
		//TimeZone.setDefault(new SimpleTimeZone(28800000,"IST"));
		
		return cal.getTime();
	}
	
	public static void main (String []args)
	{
		System.out.println(getTransactionHistory("2012-01-01", "2014-03-20"));
	}
	public static synchronized String call(String joloURL )
	{
		 URL url;
		 StringBuffer rechargeOutput= new StringBuffer();
		// String joloURL=getJoloURL(mobNo, amt, tnxId, operator);
		 LOGGER.info("request URL :: " +joloURL);
		  try {
		      
		         url = new URL(joloURL);
		         HttpURLConnection con = (HttpURLConnection)url.openConnection();
		         BufferedReader br = 
		                    new BufferedReader(
		                        new InputStreamReader(con.getInputStream()));
		         String line="";
		         while((line = br.readLine()) != null)
		         rechargeOutput.append(line);
		        
		         
		   } catch (MalformedURLException e) {
		         e.printStackTrace();
		   } catch (IOException e) {
		         e.printStackTrace();
		   }
		  LOGGER.info("response :: "+rechargeOutput);
		  return rechargeOutput.toString();
	}
	
	
	public static synchronized String recharge(String mobNo,Integer amt,Integer tnxId, String operator) {
		 
		 String joloURL=getJoloURL(mobNo, amt, tnxId, operator);
		return call(joloURL);  
	}
	
	public static synchronized String getTransactionHistory(String fromDate,String toDate)
	{
		String joloURL= getTransactionHistoryURL(fromDate, toDate);
		return call(joloURL);
	}
	
	
	public static synchronized String getJoloURL(String mobNo,Integer amt,Integer tnxId, String operator)
{

		
		return "http://jolo.in/api/recharge_advance.php?mode="+Constants.JOLO_MODE+"&key="+Constants.JOLO_APP_KEY+"&operator="+operator+"&service="+mobNo+"&amount="+amt+"&orderid="+tnxId;
		
	}
	
	public static String getJoloBalance()
	{
		return call(Constants.JOLO_BAL_URL+Constants.JOLO_APP_KEY);
	}
	
	public static synchronized String mpElectricityBillPay(String mobNo,Integer amt,Integer tnxId, String operator,String cycle,String duedate) {
		 
		 String joloURLElectBillPay=getJoloURLElectBillPay(mobNo, amt, tnxId, operator,cycle,duedate);
		return call(joloURLElectBillPay);  
	}

	
	public static synchronized String getJoloURLElectBillPay(String mobNo,Integer amt,Integer tnxId, String operator,String cycle,String duedate)
	{

			
			return "http://jolo.in/api/utility.php?mode="+Constants.JOLO_MODE+"&key="+Constants.JOLO_APP_KEY+"&operator="+operator+"&service="+mobNo+"&amount="+amt+"&cycle="+cycle+"&duedate"+duedate+"&orderid="+tnxId;
			
	}
	public static synchronized String landLineBillPay(String mobNo,Integer amt,Integer tnxId, String operator,String account) {
		 
		 String joloURLElectBillPay=getLandLineBillPay(mobNo, amt, tnxId, operator,account);
		return call(joloURLElectBillPay);  
	}

	
	public static synchronized String getLandLineBillPay(String mobNo,Integer amt,Integer tnxId, String operator,String account)
	{

			
			return "http://jolo.in/api/landline.php?mode="+Constants.JOLO_MODE+"&key="+Constants.JOLO_APP_KEY+"&operator="+operator+"&service="+mobNo+"&amount="+amt+"&other="+account;
			
	}
	
	public static synchronized String getTransactionHistoryURL(String fromDate, String toDate)
	{
		return Constants.JOLO_TNX_URL+"key="+Constants.JOLO_APP_KEY+"&fromdate="+fromDate+"&todate="+toDate;
	}
	
	
	
}

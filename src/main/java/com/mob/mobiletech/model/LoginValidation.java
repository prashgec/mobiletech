/**
 * 
 */
package com.mob.mobiletech.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mob.mobiletech.dao.BaseDAO;
import com.mob.mobiletech.domain.User;

/**
 * @author Prashant
 *
 */
public class LoginValidation {
	
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

	public User validate(String userName, String password)
	{
		/*List<Object> userList=baseDAO.fetchAll(userName, "userName", User.class.getName());
		for(Object user: userList)
		{
			if(password.equals(((User)user).getPassword()))
			{return (User)user;}
		}
		return null;*/
		
		User user=baseDAO.getUser(userName);
		if(user==null)
			return null;
		if(password.equals(user.getPassword()))
		{return user;}
		else 
			return null;
	}
}

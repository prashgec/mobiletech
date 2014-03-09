/**
 * 
 */
package com.mob.mobiletech.dao;

import java.util.List;




import javax.persistence.Entity;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.mob.mobiletech.domain.TransactionRequest;
import com.mob.mobiletech.domain.User;


/**
 * @author Prashant
 *
 */
@Transactional
public class BaseDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Autowired  
    private SessionFactory sessionFactory;



	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


    @Transactional
	public void saveOrUpdate(Object object)
	{
    	Session session= sessionFactory.openSession();
    	session.getTransaction().begin();
    	session.saveOrUpdate(object);
    	session.getTransaction().commit();
    	session.close();
	}
    
    @Transactional
	public void update(Object object)
	{
    	Session session= sessionFactory.openSession();
    	session.getTransaction().begin();
    	session.update(object);
    	session.getTransaction().commit();
    	session.close();
	}
    
    public <T extends Object,U extends Object > List<U> fetchAll(T id,String prop, String clazz)
    {
    	Session session= sessionFactory.openSession();
    	session.getTransaction().begin();
    	Criteria criteria = session.createCriteria(clazz);
    	if(prop!=null)
    	criteria.add(Restrictions.eq(prop, id));
    	return criteria.list();
    	//session.getTransaction().commit();
    	//session.close();
    }



	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    
	public Float getCommission(String dataValue)
	{
		String query="select COMMISSION from REF_DATA_MASTER where DATA_CODE =?";
		try{
		return (Float)jdbcTemplate.queryForObject(query, new Object[]{dataValue}, Float.class);
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public User getUser(String username)
	{
		String query="select * from MST_USER where username= ? and login_status='00'";
		try{
		return jdbcTemplate.queryForObject(query, new Object[]{username}, new BeanPropertyRowMapper(User.class));
		}
		catch (Exception e) {
			return null;
		}
	}
	
	/*public List<TransactionRequest> getPendingRequest()
	{
		String query="select * from MST_USER where login_status='01'";
	}*/
    
	 @Transactional
		public <T extends Object> void saveAll(List<T> list)
		{
	    	Session session= sessionFactory.openSession();
	    	session.getTransaction().begin();
	    	for(T obj: list)
	    		session.saveOrUpdate(obj);
	    	session.getTransaction().commit();
	    	session.close();
		}

}

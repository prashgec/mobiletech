/**
 * 
 */
package com.mob.mobiletech.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mob.mobiletech.domain.ReferenceData;

/**
 * @author Prashant
 *
 */
@Component
public class LoadOperatorListener implements ApplicationListener,ServletContextAware{
	private ServletContext servletContext;
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		
	}
	@Autowired
	SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	


	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
	

	/*@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		applicationContext=getContext(contextEvent);
		sessionFactory= (SessionFactory)applicationContext.getBean("sessionFactory");
		context= contextEvent.getServletContext();
		Session session= sessionFactory.openSession();
    	session.getTransaction().begin();
    	Criteria criteria = session.createCriteria(ReferenceData.class);
    	for (int i=1;i<=4;i++){
    	criteria.add(Restrictions.eq("dataId", 1));
    	context.setAttribute(i+"",criteria.list());
    	}
		
	}*/




	@Override
	public void onApplicationEvent(ApplicationEvent contextEvent) {
		/*//context= contextEvent.getServletContext();
		Session session= sessionFactory.openSession();
    	session.getTransaction().begin();
    	
    	for (int i=1;i<=4;i++){
    		Criteria criteria = session.createCriteria(ReferenceData.class);
    	criteria.add(Restrictions.eq("dataId", i));
    	servletContext.setAttribute(i+"",criteria.list());*/
		
	//}

}}

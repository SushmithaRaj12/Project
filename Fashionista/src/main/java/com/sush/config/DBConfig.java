package com.sush.config;

import java.util.Properties;

import javax.sql.DataSource;

//import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sush.model.Category;
@Configuration
@EnableTransactionManagement
public class DBConfig
{
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
		System.out.println("entering datasource");
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		//BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/myDB/test/mydb");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		System.out.println("exiting datasource");
		return dataSource;
	}
@Bean(name="sessionFactory")
     public SessionFactory getSessionFactory()
     {
	  System.out.println("entering sf");
     Properties hibernateProperties=new Properties();
     System.out.println("creating properties");
	 hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	 //hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	 hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
	 System.out.println("creating properties done");
	 System.out.println("---------");
	 
	 System.out.println("creating LocalSessionFactoryBuilder");
	 LocalSessionFactoryBuilder localsessionFactory=new LocalSessionFactoryBuilder(getH2DataSource());
	 System.out.println("LSFB done");
	 
	 System.out.println("adding properties");
	 localsessionFactory.addProperties(hibernateProperties);
	 System.out.println("properties done");
	 
	 System.out.println("adding classes");
	 Class classes[]=new Class[] {Category.class};
	 localsessionFactory.addAnnotatedClasses(classes);
	 System.out.println("classes done");
	 
	 System.out.println("--------------");
	 System.out.println("building session factory");
	 SessionFactory sessionFactory=localsessionFactory.buildSessionFactory();
	 System.out.println("SF done");
	 System.out.println("exiting sf");
	 return sessionFactory;
     }

     @Bean(name="txnmanager")
     public HibernateTransactionManager getHibernateTransactionmanager(SessionFactory sessionFactory)
     {
    	 System.out.println("entering txn");
    	 return new HibernateTransactionManager(sessionFactory);
    	 
     }
}

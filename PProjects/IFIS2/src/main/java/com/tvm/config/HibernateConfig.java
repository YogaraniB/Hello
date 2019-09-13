package com.tvm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.tvm.model"})
@EnableAspectJAutoProxy
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class HibernateConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public DriverManagerDataSource getDataSource(){
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setUrl(env.getProperty("database.url"));
		ds.setUsername(env.getProperty("database.username"));
		ds.setPassword(env.getProperty("database.password"));
		ds.setDriverClassName(env.getProperty("database.driverClassName"));
		return ds;
	}
	@Bean
	@Primary
	public Properties getHibernateProperties(){
		Properties properties=new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		return properties;
		
	}
	

	@Bean
	public LocalSessionFactoryBean getSessionFactory2(DataSource dataSource, 
			Properties properties){
		LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
		
		localSessionFactoryBean.setDataSource(dataSource);
		
		localSessionFactoryBean.setPackagesToScan("com.tvm.model");
		
		localSessionFactoryBean.setHibernateProperties(properties);
		return localSessionFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager getTxMgr(SessionFactory sessionFactory){
		HibernateTransactionManager hibernateTxMgr=new HibernateTransactionManager();
		hibernateTxMgr.setSessionFactory(sessionFactory);
		return hibernateTxMgr;
	}
}





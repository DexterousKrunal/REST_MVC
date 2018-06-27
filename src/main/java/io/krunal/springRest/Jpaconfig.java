package io.krunal.springRest;

import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource(value="classpath:Application.properties")
public class Jpaconfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean emf()
	{
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setDataSource(getdataSource());
		emf.setPackagesToScan("io.egen.springRest.entity");
		emf.setJpaProperties(getjpaproperty());
		return emf;
	}
	
	//Here all the property value set hardcoded. How to access those property from other file.
	@Bean
	private DataSource getdataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.user", "root"));
		ds.setPassword(env.getProperty("db.password", "abcd"));
		return ds;
	}
	
	private Properties getjpaproperty()
	{
		Properties ps = new Properties();
		ps.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		ps.setProperty("hibernate.hbm2ddl.auto", "create");
		ps.setProperty("hibernate.show_sql", "true");
		ps.setProperty("hibernate.format_sql", "true");
		return ps;
	}
	

}

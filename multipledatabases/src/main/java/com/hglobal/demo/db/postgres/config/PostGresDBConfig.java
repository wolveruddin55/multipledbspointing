package com.hglobal.demo.db.postgres.config;


import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "secondEntityManagerFactoryBean", basePackages = {
		"com.hglobal.demo.db.postgres.repo" }, transactionManagerRef = "secondTransactionManager")
public class PostGresDBConfig {

	@Autowired
	private Environment environment;

	@Bean(name="secondDataSource")
	@Primary
	DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(environment.getProperty("second.datasource.url"));
		dataSource.setDriverClassName(environment.getProperty("second.datasource.driver-class-name"));
		dataSource.setUsername(environment.getProperty("second.datasource.username"));
		dataSource.setPassword(environment.getProperty("second.datasource.password"));
		return dataSource;
	}

	@Bean(name = "secondEntityManagerFactoryBean")
	@Primary
	LocalContainerEntityManagerFactoryBean getEntitiyManagerFactoryBean() {
		Map<String, Object> props = new HashMap<>();
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		bean.setJpaVendorAdapter(adapter);
		props.put("hibernate.show-sql", "true");
		props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		bean.setDataSource(dataSource());
		bean.setJpaPropertyMap(props);
		bean.setPackagesToScan("com.hglobal.demo.db.postgres.entities");
		return bean;
	}

	@Primary
	@Bean(name = "secondTransactionManager")
	PlatformTransactionManager transactionManager() {
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(getEntitiyManagerFactoryBean().getObject());
		return manager;
	}
}

package com.fdmgroup.icms.appconfig;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages = { "com.fdmgroup.icms.appconfig", "com.fdmgroup.icms.models", "com.fdmgroup.icms.repositories", "com.fdmgroup.icms.controllers" })
@EnableJpaRepositories("com.fdmgroup.icms.repositories")
@EnableTransactionManagement
@Profile("live") // this profile name is used in the "production" version of the code
public class JpaConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "com.fdmgroup.icms.models", "com.fdmgroup.icms.controllers", "com.fdmgroup.icms.repositories" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
		dataSource.setMaxPoolSize(100);
		dataSource.setMinPoolSize(10);
		dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUser("trainee1");
		dataSource.setPassword("!QAZSE4");
		return dataSource;
	}

	@Bean
	public Properties additionalProperties() {
		Properties properties = new Properties();

		// change this property to "update" to have the DB persist when running
		// the app multiple times
		// alternatively, "create-drop" will drop the tables, create them at
		// startup, then drop them again on shutdown
		properties.setProperty("hibernate.hbm2ddl.auto", "update");

		// since this is the "production" environment, we won't show the SQL
		// being run during database processes
		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws PropertyVetoException {
		return new JpaTransactionManager(entityManagerFactory().getObject());
	}
}
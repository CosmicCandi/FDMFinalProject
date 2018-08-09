package com.fdmgroup.icms.classes;

	import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

	@Configuration
	@ComponentScan(basePackages= {"com.fdmgroup.icms.classes", "com.fdmgroup.icms.controllers", "com.fdmgroup.icms.enums", "com.fdmgroup.icms.models", "com.fdmgroup.icms.repositories" })
	@EnableJpaRepositories("com.fdmgroup.icms.repositories")
	@EnableTransactionManagement
	@Profile("live")  // this profile name is used in the "production" version of the code
	public class JpaConfig {
		
		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
			LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
			em.setDataSource(dataSource());
			em.setPackagesToScan(new String[] { "com.fdmgroup.icms.classes", "com.fdmgroup.icms.controllers", "com.fdmgroup.icms.enums", "com.fdmgroup.icms.models", "com.fdmgroup.icms.repositories" });

			JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
			em.setJpaVendorAdapter(vendorAdapter);
			em.setJpaProperties(additionalProperties());

			return em;
		}

		@Bean
		public DataSource dataSource() {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			dataSource.setUsername("trainee1");
			dataSource.setPassword("!QAZSE4");
			return dataSource;
		}

		@Bean
		public Properties additionalProperties() {
			Properties properties = new Properties();
			
			//change this property to "update" to have the DB persist when running the app multiple times
			//alternatively, "create-drop" will drop the tables, create them at startup, then drop them again on shutdown
			properties.setProperty("hibernate.hbm2ddl.auto", "verify");
			
			//since this is the "production" environment, we won't show the SQL being run during database processes
			properties.setProperty("hibernate.show_sql", "true");
			return properties;
		}
		
		@Bean
		public PlatformTransactionManager transactionManager() {
			return new JpaTransactionManager(entityManagerFactory().getObject());
		}
}
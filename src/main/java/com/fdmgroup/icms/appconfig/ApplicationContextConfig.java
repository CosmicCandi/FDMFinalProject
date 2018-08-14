package com.fdmgroup.icms.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fdmgroup.icms.models.Comment;
import com.fdmgroup.icms.models.Issue;
import com.fdmgroup.icms.models.SeedDatabase;
import com.fdmgroup.icms.models.User;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.fdmgroup.icms.appconfig", "com.fdmgroup.icms.models", "com.fdmgroup.icms.repositories", "com.fdmgroup.icms.controllers"})
@EnableJpaRepositories("com.fdmgroup.icms.repositories")
@EnableTransactionManagement
@Import({TestJpaConfig.class, JpaConfig.class, WebConfig.class })
public class ApplicationContextConfig {

	@Bean
	@Scope("prototype")
	public Issue issue(){
		return new Issue();
	} 
	
	@Bean
	@Scope("prototype")
	public Comment comment(){
		return new Comment();
	}
	
	@Bean
	@Scope("prototype")
	public User user(){
		return new User();
	}
	
	@Bean
	public SeedDatabase seedDatabase() {
		return new SeedDatabase();
	}
}

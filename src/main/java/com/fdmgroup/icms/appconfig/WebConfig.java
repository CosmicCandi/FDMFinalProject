package com.fdmgroup.icms.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.fdmgroup.icms.controllers.InputValidationInterceptor;

@Configuration
@ComponentScan(basePackages = { "com.fdmgroup.icms.classes", "com.fdmgroup.icms.models", "com.fdmgroup.repositories", "com.fdmgroup.icms.controllers", "com.fdmgroup.icms.enums", "com.fdmgroup.icms.interceptors" })
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
	
	private static final String PREFIX = "/WEB-INF/complaint/";
	private static final String SUFFIX = ".jsp";
	
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix(PREFIX);
		resolver.setSuffix(SUFFIX);
		return resolver;
	}
	
//	@Override
//	public void addInterceptors(InterceptorRegistry registry){
//		registry.addInterceptor(new InputValidationInterceptor());
//	}
}

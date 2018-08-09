package com.fdmgroup.icms.classes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = { "com.fdmgroup.icms.classes", "com.fdmgroup.icms.models", "com.fdmgroup.repositories" })
//, excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
public class WebConfig {
	
	private static final String PREFIX = "/WEB-INF/jsp/";
	private static final String SUFFIX = ".jsp";
	
	@Bean
	InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix(PREFIX);
		resolver.setSuffix(SUFFIX);
		return resolver;
	}
}

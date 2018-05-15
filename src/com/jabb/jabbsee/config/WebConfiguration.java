package com.jabb.jabbsee.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
//@EnableMongoRepositories(basePackages = "com.jabb.jabbsee.repository")
@ComponentScan("com.jabb.jabbsee")
public class WebConfiguration implements WebMvcConfigurer {
	
	
}

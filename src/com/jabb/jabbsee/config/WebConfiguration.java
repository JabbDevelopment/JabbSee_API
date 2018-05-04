package com.jabb.jabbsee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
//@EnableMongoRepositories(basePackages = "com.jabb.jabbsee.repository")
@Import(MongoConfiguration.class)
@ComponentScan("com.jabb.jabbsee")
public class WebConfiguration extends WebMvcConfigurerAdapter {
	
	@Autowired
	MongoConfiguration mongoConfiguration;
	
}

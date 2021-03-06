package com.jabb.jabbsee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableWebMvc
//@EnableMongoRepositories(basePackages = "com.jabb.jabbsee.repository")
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "jabbsee";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("127.0.0.1", 27017);
	}
	
	 @Override
	    protected String getMappingBasePackage() {
	        return "org.jabb";
	    }
	

}

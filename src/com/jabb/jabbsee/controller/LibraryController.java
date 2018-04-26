package com.jabb.jabbsee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jabb.jabbsee.model.Library;

@RestController
public class LibraryController {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	//Address on localhost: http://localhost:8080/JabbSeeAPI/library
	@RequestMapping(value = "/library", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Library> getLibrary(){
		Library library = new Library();
		//code to test mongo communication
		mongoTemplate.insert(library, "libraryCollection");
		return ResponseEntity.ok().body(library);
	}
	

	
}

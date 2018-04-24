package com.jabb.jabbsee.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jabb.jabbsee.model.Library;

@RestController
public class LibraryController {
	
	//Address on localhost: http://localhost:8080/JabbSeeAPI/hello
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Library sayHello() {
		return new Library();
	}
	
	@RequestMapping(value = "/library", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Library> getLibrary(){
		return ResponseEntity.ok().body(new Library());
	}
	
	

	
}

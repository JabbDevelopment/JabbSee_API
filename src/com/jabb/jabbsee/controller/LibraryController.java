package com.jabb.jabbsee.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jabb.jabbsee.model.Library;
import com.jabb.jabbsee.repository.LibraryRepository;

@RestController
public class LibraryController {
	
	@Autowired
	LibraryRepository libraryRepo;
	
	//GET LIBRARY
	//Address on localhost: http://localhost:8080/JabbSeeAPI/library
	@RequestMapping(value = "/library", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	
	public ResponseEntity<Library> getLibrary(Principal principal){
		Library library = libraryRepo.getLibrary(principal.getName());
		return ResponseEntity.ok().body(library);
	}
	
	//UPDATE LIBRARY
	@RequestMapping(value = "/library", 
			method = RequestMethod.POST, 
			consumes = "application/json", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	
	public ResponseEntity<Library> updateLibrary(@RequestBody Library library, Principal principal) {
		if(!principal.getName().equals(library.getOwner())) {
			return ResponseEntity.badRequest().body(library);
		}
		System.out.println("Updating library");
		Library updatedLibrary = libraryRepo.updateLibrary(library);
		return ResponseEntity.ok().body(updatedLibrary);	
	}
	
	//DELETE LIBRARY
	@RequestMapping(value = "/library", 
			method = RequestMethod.DELETE, 
			consumes = "application/json", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	
	public ResponseEntity<Library> deleteLibrary(@RequestBody Library library, Principal principal) {
		if(!principal.getName().equals(library.getOwner())) {
			return ResponseEntity.badRequest().body(library);
		}
		Library deletedLibrary = libraryRepo.deleteLibrary(library);
		return ResponseEntity.ok().body(deletedLibrary);	
	}
	
	//CREATE NEW LIBRARY
	/*@RequestMapping(value = "/library", 
			method = RequestMethod.POST, 
			consumes = "application/json", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	
	public ResponseEntity<Library> createLibrary(@RequestBody Library library) {		
		Library createdLibrary = libraryRepo.createLibrary(library);
		return ResponseEntity.ok().body(createdLibrary);	
	}*/
	
	
	//ADD NEW SERIE
	/*@RequestMapping(value = "/serie", 
			method = RequestMethod.POST, 
			consumes = "application/json", 
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	
	public ResponseEntity<Serie> addSerie(@RequestBody Serie serie) {
		Serie addedSerie = libraryRepo.addSerie(serie);
		return ResponseEntity.ok().body(addedSerie);	
	}*/

	
	
	
}

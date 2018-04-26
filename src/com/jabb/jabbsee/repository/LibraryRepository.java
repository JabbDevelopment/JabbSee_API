package com.jabb.jabbsee.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jabb.jabbsee.model.Library;

public interface LibraryRepository extends MongoRepository<Library, String>{
	

}

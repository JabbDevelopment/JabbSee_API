package com.jabb.jabbsee.repository;

import com.jabb.jabbsee.model.Library;

public interface LibraryRepository {
	
	public Library createLibrary(Library library);
	public Library updateLibrary(Library library);
	public Library getLibrary(String owner);
	public Library deleteLibrary(Library library);
	
}

package com.jabb.jabbsee.repository;

import com.jabb.jabbsee.model.Library;
import com.jabb.jabbsee.model.Serie;

public interface LibraryRepository {
	
	public Library createLibrary(Library library);
	public Library updateLibrary(Library library);
	public Library getLibrary();
	public Library deleteLibrary(Library library);
	public Serie addSerie(Serie serie);
	
}

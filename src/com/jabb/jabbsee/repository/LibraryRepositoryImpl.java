package com.jabb.jabbsee.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.jabb.jabbsee.model.Library;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	private final String COLLECTION_NAME = "libraryCollection";
	private final String OWNER_VAR = "owner";
	private final String SERIES_LIST_VAR = "seriesList";

	@Override
	public Library createLibrary(Library library) {
		mongoTemplate.insert(library, COLLECTION_NAME);
		return library;
	}

	@Override
	public Library updateLibrary(Library library) {
		String owner = library.getOwner();
		Query query = Query.query(Criteria.where(OWNER_VAR).is(owner));
		Update update = new Update().set(SERIES_LIST_VAR, library.getSeriesList());
		mongoTemplate.updateFirst(query, update, COLLECTION_NAME);
		Library updatedLibrary = mongoTemplate.findOne(query, Library.class, COLLECTION_NAME);
		return updatedLibrary;
	}

	@Override
	public Library getLibrary(String owner) {
		Query query = Query.query(Criteria.where(OWNER_VAR).is(owner));
		Library library = mongoTemplate.findOne(query, Library.class, COLLECTION_NAME);
		return library;
	}

	@Override
	public Library deleteLibrary(Library library) {
		Query query = Query.query(Criteria.where(OWNER_VAR).is("alfons"));
		mongoTemplate.remove(query, Library.class, COLLECTION_NAME);
		Library deletedLibrary = mongoTemplate.findOne(query, Library.class, COLLECTION_NAME);
		return deletedLibrary;
	}

	/*@Override
	public Serie addSerie(Serie serie) {
		Query query = Query.query(Criteria.where(OWNER_VAR).is("bea"));
		Update update = new Update().push(SERIES_LIST_VAR, serie);
		mongoTemplate.updateFirst(query, update, COLLECTION_NAME);
		return serie;
	}*/

}

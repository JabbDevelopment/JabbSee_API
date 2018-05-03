package com.jabb.jabbsee.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Library implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Serie> seriesList;
	private String owner;
	
	public Library() {
		this.seriesList = new ArrayList<>();
		//temporary code for testing db
		Serie serie1 = new Serie("arrow");
		Serie serie2 = new Serie("game of thrones");
		this.seriesList.add(serie1);
		this.seriesList.add(serie2);
	}

	public List<Serie> getSeriesList() {
		return seriesList;
	}

	public void setSeriesList(List<Serie> seriesList) {
		this.seriesList = seriesList;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	

	
}

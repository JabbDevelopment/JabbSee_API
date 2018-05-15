package com.jabb.jabbsee.model;

import java.io.Serializable;
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

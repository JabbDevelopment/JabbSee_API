package com.jabb.jabbsee.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Serie> seriesList;
	
	public Library() {
		this.seriesList = new ArrayList<>();
		Serie serie1 = new Serie("arrow");
		Serie serie2 = new Serie("once");
		this.seriesList.add(serie1);
		this.seriesList.add(serie2);
	}

	public List<Serie> getSeriesList() {
		return seriesList;
	}

	public void setSeriesList(List<Serie> seriesList) {
		this.seriesList = seriesList;
	}

	
}

package com.example.service;

import java.util.List;

import com.example.entity.Tours;

public interface toursService {
	List<Tours> getAllTours();
	
	Tours getTourById(int id);
	
	void saveTour(Tours tour);
	
	void deleteTourById(int id);
}

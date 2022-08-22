package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Tours;
import com.example.repo.ToursRepo;

@Service
public class toursServiceImpl implements toursService{
	@Autowired
	private ToursRepo tRepo;
	
	
	
	public toursServiceImpl(ToursRepo tRepo) {
		super();
		this.tRepo = tRepo;
	}

	@Override
	public List<Tours> getAllTours() {
		
		return tRepo.findAll();
		
	}

	@Override
	public Tours getTourById(int id) {
		Optional<Tours> optional = tRepo.findById(id);
		
		Tours tour = null;
		if(optional.isPresent()) {
			tour = optional.get();
		} else {
			throw new RuntimeException("Member not found for id ::" + id);
		}
		return tour;
	}

	@Override
	public void saveTour(Tours tour) {
		this.tRepo.save(tour);
		
	}

	@Override
	public void deleteTourById(int id) {
		this.tRepo.deleteById(id);
}
}

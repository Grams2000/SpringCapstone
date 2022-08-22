package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Tours;
import com.example.entity.question;
import com.example.repo.ToursRepo;
import com.example.repo.questionRepo;

@Service
public class questionServiceImpl implements questionService{
	@Autowired
	private questionRepo qRepo;
	
	
	
	public questionServiceImpl(questionRepo qRepo) {
		super();
		this.qRepo = qRepo;
	}

	@Override
	public List<question> getAllQuestions() {
		
		return qRepo.findAll();
		
	}

	@Override
	public question getQuestionById(int id) {
		Optional<question> optional = qRepo.findById(id);
		
		question question = null;
		if(optional.isPresent()) {
			question = optional.get();
		} else {
			throw new RuntimeException("Member not found for id ::" + id);
		}
		return question;
	}

	@Override
	public void saveQuestion(question question) {
		this.qRepo.save(question);
		
	}

	@Override
	public void deleteQuestionById(int id) {
		this.qRepo.deleteById(id);
}
}

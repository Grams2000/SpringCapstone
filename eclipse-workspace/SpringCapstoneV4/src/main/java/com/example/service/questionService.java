package com.example.service;

import java.util.List;

import com.example.entity.Tours;
import com.example.entity.question;

public interface questionService {
	List<question> getAllQuestions();
	
	question getQuestionById(int id);
	
	void saveQuestion(question question);
	
	void deleteQuestionById(int id);
}

package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Tours;
import com.example.entity.question;

@Repository
public interface questionRepo extends JpaRepository<question, Integer>{

	Tours findByid(int id);
}

package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Tours;

@Repository
public interface ToursRepo extends JpaRepository<Tours, Integer>{

	Tours findByid(int id);
}

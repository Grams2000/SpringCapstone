package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Member;

@Repository
public interface memberRepo extends JpaRepository<Member, Integer>{

	Member findByEmail(String email);
	
	Member findByid(int id);
	

}

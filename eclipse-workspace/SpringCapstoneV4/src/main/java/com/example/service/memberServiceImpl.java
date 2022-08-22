package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.entity.Member;
import com.example.entity.Tours;
import com.example.repo.memberRepo;

@Service
@Repository
public class memberServiceImpl implements memberService {
	@Autowired
	private memberRepo mRepo;
	
	// define field for entitymanager
	private EntityManager entityManager;
	
	@Autowired
	public memberServiceImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	public memberServiceImpl(memberRepo mRepo) {
		super();
		this.mRepo = mRepo;
	}
	@Override
	public List<Member> getAllMembers() {
		
		return mRepo.findAll();
		
	}

	@Override
	public Member getMemberById(int id) {
		Optional<Member> optional = mRepo.findById(id);
		
		Member member = null;
		if(optional.isPresent()) {
			member = optional.get();
		} else {
			throw new RuntimeException("Member not found for id ::" + id);
		}
		return member;
	}

	@Override
	public void saveMember(Member member) {
		this.mRepo.save(member);
		
	}

	@Override
	public void deleteMemberById(int id) {
		this.mRepo.deleteById(id);
}
	@Override
	public Set<Tours> getMemberTours(Integer id) {
	// get the current session from hibernate
		Session currentSession = entityManager.unwrap(Session.class);
		// get the employee
		Member member = currentSession.get(Member.class, id);
		
		Set<Tours> tours = member.getTour();
		return tours;
	}
	
//	@Override
//	@Transactional
//	public Set<Tours> getMemberTours(Integer id) {
//		return mRepo.getMember_Tours(id);
//	}
}

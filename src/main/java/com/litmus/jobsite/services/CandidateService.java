package com.litmus.jobsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.litmus.jobsite.models.Candidate;
import com.litmus.jobsite.repositories.CandidateRepository;

@Service
public class CandidateService {
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	public Candidate findByFirstName(String firstName){
		return candidateRepository.findByFirstName(firstName);
	}
	
	public void save(Candidate c){
		candidateRepository.save(c);
	}

}

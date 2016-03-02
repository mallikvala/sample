package com.litmus.jobsite.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.litmus.jobsite.models.Candidate;

public interface CandidateRepository extends MongoRepository<Candidate, String> {
	Candidate findByFirstName(String firstName);
}

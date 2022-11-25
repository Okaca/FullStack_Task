package com.ekiptesin_ats.ats_rest.repository;

import com.ekiptesin_ats.ats_rest.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean
// CRUD refers Create, Read, Update, Delete

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

}

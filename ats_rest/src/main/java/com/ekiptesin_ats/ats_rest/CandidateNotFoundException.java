package com.ekiptesin_ats.ats_rest;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CandidateNotFoundException extends RuntimeException {
    public CandidateNotFoundException(int id){
        super(String.format("Candidate by id %d is not found...",id));
    }
}


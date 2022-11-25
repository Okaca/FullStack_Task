package com.ekiptesin_ats.ats_rest.service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekiptesin_ats.ats_rest.entity.Candidate;
import com.ekiptesin_ats.ats_rest.repository.CandidateRepository;
import com.ekiptesin_ats.ats_rest.CandidateNotFoundException;

@Service                //to get instance from context aka functions
public class CandidateService {

    @Autowired          //inject respo into service bean
    private CandidateRepository repository;
    // valid statuses
    private final List<String> validStatus = new ArrayList<>(Arrays.asList("applied", "interview", "rejected", "offer-sent", "hired"));

    //Create a new candidate
    public Candidate createCandidate(Candidate candidate) throws InvalidParameterException{
        if(!validStatus.contains(candidate.getStatus()))
            throw new InvalidParameterException("Status can only include 'applied, interview, rejected, offer-sent, hired'");
        return repository.save(candidate);
    }

    //Create a list of new candidate
    public List<Candidate> createCandidates(List<Candidate> candidates){
        return repository.saveAll(candidates);
    }

    //Get all candidates
    public List<Candidate> getCandidates(){
        return repository.findAll();
    }

    //Get a specific candidate with id
    public Candidate getCandidateById(int id){
        return repository.findById(id).orElseThrow(() -> new CandidateNotFoundException(id));
    }

    //Remove the candidate (searching parameter should be id)
    public String deleteCandidate(int id){
        repository.deleteById(id);
        return String.format("Candidate by id %d is deleted...",id); 
    }

    //Update the candidate (searching parameter should be id)
    public Candidate updateCandidate(int id, Candidate candidate){
        Candidate formerCandidate = getCandidateById(id);


        try{
            if (!candidate.getName().isEmpty())
                formerCandidate.setName(candidate.getName());
        }catch(NullPointerException e){
            ;
        }
        try{
            if (!candidate.getSurname().isEmpty())
                formerCandidate.setSurname(candidate.getSurname());
        }catch(NullPointerException e){
            ;
        }
        try{
            if (!candidate.getEmail().isEmpty())
                formerCandidate.setEmail(candidate.getEmail());
        }catch(NullPointerException e){
            ;
        }
        try{
            if (!candidate.getNotes().isEmpty())
                formerCandidate.setNotes(candidate.getNotes());
        }catch(NullPointerException e){
            ;
        }
        try{
            if (!candidate.getStatus().isEmpty() && validStatus.contains(candidate.getStatus()))
                formerCandidate.setStatus(candidate.getStatus());
        }catch(NullPointerException e){
            ;
        }
        return repository.save(formerCandidate);
    }



}

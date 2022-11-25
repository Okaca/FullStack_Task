package com.ekiptesin_ats.ats_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ekiptesin_ats.ats_rest.entity.Candidate;
import com.ekiptesin_ats.ats_rest.service.CandidateService;

@RestController         // indicates that the data returned by each method will be written straight into the response body instead of rendering a template
@CrossOrigin            // hook backend with the react app
public class CandidateController {
    
    @Autowired
    private CandidateService service;

    @PostMapping("/createCandidate")
    public Candidate addCandidate(@RequestBody Candidate candidate){
        return service.createCandidate(candidate);
    }

    @PostMapping("/createCandidates")
    public List<Candidate> addCandidates(@RequestBody List<Candidate> candidates){
        return service.createCandidates(candidates);
    }

    @GetMapping("/candidates")
    public List<Candidate> findAllCandidates(){
        return service.getCandidates();
    }

    @GetMapping("/getCandidate/{id}")
    public Candidate findCandidateByID(@PathVariable int id){
        return service.getCandidateById(id);
    }

    @PutMapping("/updateCandidate/{id}")
    public Candidate updateCandidate(@PathVariable int id,@RequestBody Candidate candidate){
        return service.updateCandidate(id, candidate);
    }

    @DeleteMapping("/deleteCandidate/{id}")
    public String deleteCandidate(@PathVariable int id){
        return service.deleteCandidate(id);
    }

}

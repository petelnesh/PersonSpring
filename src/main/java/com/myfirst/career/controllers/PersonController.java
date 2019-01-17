/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfirst.career.controllers;

import com.myfirst.career.entity.Person;
import com.myfirst.career.exceptions.ResourceNotFoundException;
import com.myfirst.career.repository.PersonRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author techsavanna
 */
@RestController
@RequestMapping("/api/v1")
public class PersonController {
     @Autowired
    private PersonRepository personRepository;
    
   
//    public PersonController(PersonRepository personRepository){
//        this.personRepository=personRepository;
//    }
    @GetMapping("/applicants")
    public List<Person> listperson(){
        return personRepository.findAll();
    }
//    @GetMapping("/insert")
//    public String insert(){
//      for(int i=0; i < 10; i++){
//          personRepository.save(new Person("fname" + i,"lname" + i));
//      }  
//      return "inserted";
//    }
    
     @GetMapping("/applicants/{id}")
       public ResponseEntity<Person> getApplicantById(@PathVariable(value = "id") Long applicantId)
        throws ResourceNotFoundException {
        Person applicant =personRepository.findById(applicantId)
        .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + applicantId));
        return ResponseEntity.ok().body(applicant);
    }
       
        @PostMapping("/applicants")
        public Person createApplicant(@Valid @RequestBody Person applicant) {
        return personRepository.save(applicant);
    }
        @PutMapping("/applicants/{id}")
    public ResponseEntity<Person> updateApplicant(@PathVariable(value = "id") Long applicantId,
         @Valid @RequestBody Person applicantDetails) throws ResourceNotFoundException {
         Person applicant = personRepository.findById(applicantId)
        .orElseThrow(() -> new ResourceNotFoundException("Applicant not found for this id :: " + applicantId));

        applicant.setFname(applicantDetails.getFname());
        applicant.setLname(applicantDetails.getLname());
        applicant.setEmail(applicantDetails.getEmail());
        applicant.setPhone(applicantDetails.getPhone());
        applicant.setEducation_level(applicantDetails.getEducation_level());
        applicant.setYears_of_experience(applicantDetails.getYears_of_experience());
        final Person updatedApplicant =personRepository.save(applicant);
        return ResponseEntity.ok(updatedApplicant);
    }
@DeleteMapping("/applicants/{id}")
    public Map<String, Boolean> deleteApplicant(@PathVariable(value = "id") Long applicantId)
        throws ResourceNotFoundException {
        Person applicant = personRepository.findById(applicantId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + applicantId));

       personRepository.delete(applicant);
       Map<String, Boolean> response = new HashMap<>();
       response.put("Job Applicant deleted", Boolean.TRUE);
       return response;
    }
    
}

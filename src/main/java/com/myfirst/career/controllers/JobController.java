/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfirst.career.controllers;

import com.myfirst.career.entity.Job;
import com.myfirst.career.exceptions.ResourceNotFoundException;
import com.myfirst.career.repository.JobRepository;
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
public class JobController {
     @Autowired
    private JobRepository jobRepository;

    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable(value = "id") Long jobId)
        throws ResourceNotFoundException {
        Job job = jobRepository.findById(jobId)
        .orElseThrow(() -> new ResourceNotFoundException("Job not found for this id :: " + jobId));
        return ResponseEntity.ok().body(job);
    }

    @PostMapping("/jobs")
    public Job createJob(@Valid @RequestBody Job job) {
        return jobRepository.save(job);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable(value = "id") Long jobId,
         @Valid @RequestBody Job jobDetails) throws ResourceNotFoundException {
         Job job = jobRepository.findById(jobId)
        .orElseThrow(() -> new ResourceNotFoundException("Job not found for this id :: " + jobId));

        job.setName(jobDetails.getName());
        job.setDescription(jobDetails.getDescription());
        job.setJob_type(jobDetails.getJob_type());
        job.setYears(jobDetails.getYears());
        job.setEducation_level(jobDetails.getEducation_level());
        job.setStatus(jobDetails.getStatus());
        job.setDate(jobDetails.getDate());
        job.setStart_time(jobDetails.getStart_time());
        job.setEnd_time(jobDetails.getEnd_time());
        final Job updatedJob = jobRepository.save(job);
        return ResponseEntity.ok(updatedJob);
    }

    @DeleteMapping("/jobs/{id}")
    public Map<String, Boolean> deleteJob(@PathVariable(value = "id") Long jobId)
        throws ResourceNotFoundException {
        Job job = jobRepository.findById(jobId)
        .orElseThrow(() -> new ResourceNotFoundException("Job not found for this id :: " + jobId));

       jobRepository.delete(job);
       Map<String, Boolean> response = new HashMap<>();
       response.put("Job deleted", Boolean.TRUE);
       return response;
    }
}

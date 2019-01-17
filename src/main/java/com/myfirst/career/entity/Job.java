/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfirst.career.entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author techsavanna
 */
@Entity
@Table(name = "jobs")
public class Job {
     @Id
     @GeneratedValue(strategy=  GenerationType.AUTO)
     @Column(name= "id")
     private Long id;
    
    @Column(name = "job_name")
    private String name;
    
    @Column(name="job_description")
    private String description;
    
    @Column(name = "job_type")
    private String job_type;
            
    @Column(name = "years_of_experience")        
    private int years;
    
    
    @Column(name = "education_level")
    private String education_level;
    
     @Column(name = "status")
     private String status;
     
     @Column(name = "interview_date")
     private LocalDate date;
     
     @Column(name="interview_start_time")
     private String start_time;
     
     @Column(name = "interview_end_time")
     private String end_time;
     
    @Column(name="created_at")
    private ZonedDateTime created_at;

    public Job() {
    }

    public Job(Long id, String name, String description, String job_type, int years, String education_level, String status, LocalDate date, String start_time, String end_time, ZonedDateTime created_at) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.job_type = job_type;
        this.years = years;
        this.education_level = education_level;
        this.status = status;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getEducation_level() {
        return education_level;
    }

    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public ZonedDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(ZonedDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", name=" + name + ", description=" + description + ", job_type=" + job_type + ", years=" + years + ", education_level=" + education_level + ", status=" + status + ", date=" + date + ", start_time=" + start_time + ", end_time=" + end_time + ", created_at=" + created_at + '}';
    }

}

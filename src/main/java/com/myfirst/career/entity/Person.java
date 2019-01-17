/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myfirst.career.entity;

import java.io.Serializable;
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
@Table(name="person")
public class Person implements Serializable{
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name="id")
    private Long id;
  @Column(name="fname")
   private  String fname;
  @Column(name="lname")
  private   String lname;
  
  @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "education_level")
    private String education_level;
    
    @Column(name = "years_of_experience")
    private int years_of_experience;

    @Column(name="created_at")
    private ZonedDateTime created_at;
    

    public Person() {
    }

    public Person(Long id, String fname, String lname, String email, String phone, String education_level, int years_of_experience, ZonedDateTime created_at) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
        this.education_level = education_level;
        this.years_of_experience = years_of_experience;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducation_level() {
        return education_level;
    }

    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }

    public int getYears_of_experience() {
        return years_of_experience;
    }

    public void setYears_of_experience(int years_of_experience) {
        this.years_of_experience = years_of_experience;
    }

    public ZonedDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(ZonedDateTime created_at) {
        this.created_at = created_at;
    }

     @Override
    public String toString() {
        return "Person{" + "id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", phone=" + phone + ", education_level=" + education_level + ", years_of_experience=" + years_of_experience + ", created_at=" + created_at + '}';
    }

}

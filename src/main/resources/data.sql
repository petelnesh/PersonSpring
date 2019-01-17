/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  david
 * Created: Jan 11, 2019
 */
 
INSERT INTO person(id,fname, lname,email,phone, education_level, years_of_experience,created_at)VALUES 
(1,'peterson', 'mune','peterson9munene@gmail.com','0708529798','secondary',3,'2016-01-01T10:24:00+01:00');

/*Insert Jobs*/
INSERT INTO jobs(id,job_name,job_description, job_type, years_of_experience, 
            education_level,status,interview_date,interview_start_time,interview_end_time, created_at ) VALUES
(1,'web developer','my job description', 'API Engineer', 3,'graduate','accepting','2016-01-01','8.30a.m','02.00p,m','2016-01-01T10:24:00+01:00');


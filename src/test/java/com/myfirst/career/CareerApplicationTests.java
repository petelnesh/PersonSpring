package com.myfirst.career;

import com.myfirst.career.entity.Job;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CareerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class CareerApplicationTests {

	 @Autowired
     private TestRestTemplate restTemplate;

     @LocalServerPort
     private int port;

     private String getRootUrl() {
         return "http://localhost:" + port + "/api/v1";
     }

     @Test
     public void contextLoads() {

     }

     @Test
     public void testGetAllJobs() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/jobs",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetJobById() {
        Job job = restTemplate.getForObject(getRootUrl() + "/jobs/1", Job.class);
        System.out.println(job);
        assertNotNull(job);
    }

    @Test
    public void testCreateJob() {
        Job job = new Job();
        job.setName("david");
        job.setDescription("mwangi");
        job.setJob_type("backend");
        job.setYears(2);
        job.setEducation_level("post graduate");
        job.setStatus("accepting offers");
        job.setStart_time("08.30a.m");
        job.setEnd_time("12.00p.m");
        ResponseEntity<Job> postResponse = restTemplate.postForEntity(getRootUrl() + "/jobs", job, Job.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateJob() {
        int id = 1;
        Job job = restTemplate.getForObject(getRootUrl() + "/jobs/" + id, Job.class);
        job.setName("Backend Devloper");
        job.setDescription("This is role includes creating microservices");
        job.setJob_type("API");
        job.setYears(2);
        job.setEducation_level("post graduate");
        job.setStatus("accepting offers");
        job.setStart_time("08.30a.m");
        job.setEnd_time("12.00p.m");
        restTemplate.put(getRootUrl() + "/jobs/" + id, job);
        Job updatedJob = restTemplate.getForObject(getRootUrl() + "/jobs/" + id, Job.class);
        assertNotNull(updatedJob);
    }

    @Test
    public void testDeleteJob() {
         int id = 1;
         Job job = restTemplate.getForObject(getRootUrl() + "/jobs/" + id, Job.class);
         assertNotNull(job);
         restTemplate.delete(getRootUrl() + "/jobs/" + id);
         try {
              job = restTemplate.getForObject(getRootUrl() + "/jobs/" + id, Job.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }

}


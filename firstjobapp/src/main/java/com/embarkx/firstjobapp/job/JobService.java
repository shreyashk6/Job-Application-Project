package com.embarkx.firstjobapp.job;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobService {//setted as interface for loose coupling
    List<Job> findAll();//retuns all the jobs
    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}

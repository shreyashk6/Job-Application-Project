package com.embarkx.firstjobapp.job.impl;

import com.embarkx.firstjobapp.job.Job;
import com.embarkx.firstjobapp.job.JobRepository;
import com.embarkx.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  //declared this class as service
public class JobServiceImpl implements JobService {
//    private List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;
    private Long nextId=1L;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        //job.setId(nextId++);
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
//        for (Job job: jobs){
//            if (job.getId().equals(id)){
//                return job;
//            }
//        }
//        return null;
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
//        Iterator<Job> iterator = jobs.iterator();
//        while (iterator.hasNext()){
//            Job job = iterator.next();
//            if(job.getId().equals(id)){
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;
//        try {
//            jobRepository.deleteById(id);
//            return true;
//        }catch (Exception e){
//            return false;
//        }
        //CUSTOM ADDED
        try {
            if (jobRepository.existsById(id)) {
                jobRepository.deleteById(id);
                return true;
            } else {
                return false; // job not found
            }
        } catch (Exception e) {
            e.printStackTrace(); // optional: log the error instead
            return false;
        }
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
//        for(Job job : jobs){
//            if(job.getId().equals(id)){
              if(jobOptional.isPresent()) {
                  Job job = jobOptional.get();
                  job.setTitle(updatedJob.getTitle());
                  job.setDescription(updatedJob.getDescription());
                  job.setMinSalary(updatedJob.getMinSalary());
                  job.setLocation(updatedJob.getLocation());
                  job.setMaxSalary(updatedJob.getMaxSalary());
                  jobRepository.save(job);
                  return true;
              }
        return false;
    }


}


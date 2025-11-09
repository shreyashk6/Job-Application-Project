package com.embarkx.firstjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

//now changes using REQUEST MAPPING --> (OPTIONAL)     //acts as parent in below line for the whole class.
@RequestMapping("/jobs")//sets a base url for the whole class!  //changes in line 23,29,34,43,54 -->
public class JobController {
    //private List<Job> jobs = new ArrayList<>();
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


   // @GetMapping("/jobs")
    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        //return ResponseEntity(jobService.findAll(),HttpStatus.ok);
        return ResponseEntity.ok(jobService.findAll());
    }

//    @PostMapping("/jobs")
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully!",HttpStatus.CREATED);
    }
//    @GetMapping("/jobs/{id}")
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){  //PathVariable makes sure whatever is passed in the URL(GETMAPPING{ID})(Id here) is sent to this parameter(Long Id),
        Job job =jobService.getJobById(id);
        if(job !=null)
            return new ResponseEntity<>(job, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    //@DeleteMapping("/jobs/{id}")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean deleted = jobService.deleteJobById(id);
        if(deleted){
            return new ResponseEntity<>("Job Deleted Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @PutMapping("/jobs/{id}")
    //we can also use REQUESTMAPPING
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)//u have to specify here extra
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id, updatedJob);
        if(updated){
            return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

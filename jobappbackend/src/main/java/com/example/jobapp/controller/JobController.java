package com.example.jobapp.controller;

import com.example.jobapp.model.Job;
import com.example.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.ArrayList;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    JobService jobservice;

    public JobController(JobService jobservice) {
        this.jobservice = jobservice;
    }

    @GetMapping("/alljobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobservice.getAllJobs());
    }
//    public ResponseEntity<List<Job>> getAllJobs() {
//        List<Job> allJobs = jobservice.getAllJobs(); // Corrected method call
//        return ResponseEntity.ok().body(allJobs);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJob(@PathVariable Long id){
        return ResponseEntity.ok(jobservice.getJobById(id)); // use ResponseEntity.ok() or  ResponseEntity<>("xyz  ", HttpStatus.OK);
    }

    @PostMapping("/add")
    public Job addNewJob(@RequestBody Job job){
        return jobservice.addJob(job);
    }

    @PostMapping("/addmultiple")
    public List<Job> multipleJobs(@RequestBody List<Job> jobs){
        return jobservice.addMultipleJob(jobs);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateJob(@RequestBody Job job){
        jobservice.updateJob(job);
        return new ResponseEntity<>("Data Successfully Updated..!", HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public String deleteJob(Long id){
        return jobservice.removeJob(id);
    }

    @GetMapping("/search")  // /jobs/search?searchTerm=example
    public List<Job> search(@RequestParam String searchTerm){
        return jobservice.searchJob(searchTerm);
    }

}

package com.example.jobapp.service;

import com.example.jobapp.model.Job;
import com.example.jobapp.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    @Autowired
    private final JobRepository jobRepository;
    private Job job;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }
    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> addMultipleJob(List<Job> jobs){
        return jobRepository.saveAll(jobs);
    }

    public Job updateJob(Job job) {
        Job existingJob = jobRepository.findById(job.getId()).orElse(null);
        if(existingJob != null){
            existingJob.setJobtitle(job.getJobtitle());
            existingJob.setJobdescription(job.getJobdescription());
            existingJob.setExperience(job.getExperience());
            existingJob.setMinSalary(job.getMinSalary());
            existingJob.setMaxSalary(job.getMaxSalary());
            existingJob.setSkills(job.getSkills());
            existingJob.setLocation(job.getLocation());
            return jobRepository.save(existingJob);
        }
        return null;
    }

    public String removeJob(Long id){
        if(jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return "Job-id" + id + " deleted sucessfully..!";
        }else {
            return "Job with ID " + id + " does not exist.";
        }
    }

//    public boolean deleteJobById(Long id){
//        Iterator<Job> iterate = jobRepository.iterator();
//    }

    public List<Job> searchJob(String search){
        return jobRepository.findByJobtitleContainingOrJobdescriptionContainingOrLocationContainingOrSkillsContaining(search, search, search, search);
    }
}

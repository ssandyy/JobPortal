package com.example.jobapp.repository;

import com.example.jobapp.model.Job;

//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//public interface JobRepository extends MongoRepository<Job, Long> {
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByJobtitleContainingOrJobdescriptionContainingOrLocationContainingOrSkillsContaining(String jobtitle, String jobdescription, String location, String skills);
}

package com.example.jobapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

//@Document(collection = "jobapp")
@Data
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobtitle;
    private String jobdescription;
    private int experience;
    @ElementCollection
    private List<String> skills;
    private String minSalary;
    private String maxSalary;
    private String location;

//    @JsonIgnore
    @ManyToOne
    private Company company;


}

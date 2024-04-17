package com.example.jobapp.controller;

import com.example.jobapp.model.Company;
import com.example.jobapp.model.Job;
import com.example.jobapp.repository.CompanyRepository;
import com.example.jobapp.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompaniesController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAllCompany() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }
//    @GetMapping("/all")
//    public List<Company> getAllCompany() {
//        return companyService.getAllCompanies();
//    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.getCompany(id));
    }
    @PostMapping("/add")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.addCompany(company));
    }
    @PostMapping("/add_multiple")
    public ResponseEntity<List<Company>> createMultipleCompany(@RequestBody List<Company> companyList) {
        return ResponseEntity.ok(companyService.addMultipleCompany(companyList));
    }
    @PutMapping("/update")
    public ResponseEntity<Company> update(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.updateCompany(company));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        companyService.deleteCompany(id);
        return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK);
    }


}

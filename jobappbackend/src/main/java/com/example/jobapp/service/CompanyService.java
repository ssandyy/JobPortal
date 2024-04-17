package com.example.jobapp.service;

import com.example.jobapp.model.Company;
import com.example.jobapp.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // or create constructor manually..!
public class CompanyService {

    @Autowired
    private  CompanyRepository companyRepository;


    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> addMultipleCompany(List<Company> companyList) {
        return companyRepository.saveAll(companyList);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public Company updateCompany(Company company){
        Company existingCompany = companyRepository.findById(company.getId()).orElse(null);
        if(existingCompany != null){
            existingCompany.setName(company.getName());
            existingCompany.setDescription(company.getDescription());
            existingCompany.setJobs(company.getJobs());
            return companyRepository.save(existingCompany);
        }
        return null;
    }

    public String deleteCompany(Long id){
        Company selectedCompany = companyRepository.findById(id).orElse(null);
        if(selectedCompany != null){
            companyRepository.deleteById(id);
            return "Company " + selectedCompany.getName() + " deleted Sucessfully";
        }
        return "Company " + selectedCompany.getName()+"Not found..!";
    }
}

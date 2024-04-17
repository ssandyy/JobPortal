package com.example.jobapp.service;

import com.example.jobapp.model.Company;
import com.example.jobapp.model.Review;
import com.example.jobapp.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public List<Review> getAllReviews(Long companyId){
        List<Review>  reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    public boolean addReview(Long companyId, Review review){
        Company company = companyService.getCompany(companyId);
        if(company != null){
            review.setCompany(company);
           reviewRepository.save(review);
           return true;
        }else{
            return false;
        }
    }

    public Review getReview(Long companyid, Long id){
        List<Review> reviews = reviewRepository.findByCompanyId(companyid);
        return reviews.stream()
                .filter(review -> review.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

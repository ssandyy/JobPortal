package com.example.jobapp.controller;

import com.example.jobapp.model.Review;
import com.example.jobapp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review) {
         boolean isReviewSaved = reviewService.addReview(companyId, review);
        if(isReviewSaved) {
            return new ResponseEntity<>("Review added Sucessfully..!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review Not Found..!", HttpStatus.NOT_FOUND);
        }
    }
}

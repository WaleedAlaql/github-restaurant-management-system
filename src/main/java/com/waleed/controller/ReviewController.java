package com.waleed.controller;

import com.waleed.DTO.CreateReviewRequest;
import com.waleed.entity.Restaurant;
import com.waleed.entity.Review;
import com.waleed.service.ReviewServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewServiceImpl reviewService;

    public ReviewController(ReviewServiceImpl reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review savedReview = reviewService.createReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReview);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId){
        Review review = reviewService.getReviewById(reviewId);
        return ResponseEntity.ok(review);
    }

    @PutMapping("/update/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long reviewId, @RequestBody Review review){
        reviewService.updateReview(reviewId, review);
        return ResponseEntity.ok("Review updated successfully");
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReviewById(@PathVariable Long reviewId){
        reviewService.deleteReviewById(reviewId);
        return ResponseEntity.ok("Menu deleted successfully");
    }

    @PostMapping("/{restaurantId}/create-review")
    public Review createReviewRequest(@PathVariable Restaurant restaurantId, @RequestBody CreateReviewRequest request) {
        return reviewService.createReviewRequest(restaurantId, request.getContent(), request.getRating(), request.getCustomer());
    }
}

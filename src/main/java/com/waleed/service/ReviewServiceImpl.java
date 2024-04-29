package com.waleed.service;

import com.waleed.entity.Customer;
import com.waleed.entity.Restaurant;
import com.waleed.entity.Review;
import com.waleed.exception.ReviewNotFoundException;
import com.waleed.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Review with id: " + id + " not found"));
    }

    public Review updateReview(Long reviewId, Review updatedReview){
        Review existingReview = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException("Review with id: " + reviewId + " not found"));

        existingReview.setContent(updatedReview.getContent());
        existingReview.setRating(updatedReview.getRating());
        return reviewRepository.save(existingReview);
    }

    public void deleteReviewById(Long reviewId){
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFoundException("Review with id: " + reviewId + " not found"));
        reviewRepository.delete(review);
    }

    @Override
    public Review createReviewRequest(Restaurant restaurantId, String content, Double rating, Customer customer) {
        Review review = new Review();
        review.setRestaurant(restaurantId);
        review.setContent(content);
        review.setRating(rating);
        review.setCustomer(customer);
        return reviewRepository.save(review);
    }
}

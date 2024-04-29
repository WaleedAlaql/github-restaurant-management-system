package com.waleed.service;

import com.waleed.entity.Customer;
import com.waleed.entity.Restaurant;
import com.waleed.entity.Review;
import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews();

    Review createReview(Review review);

    Review getReviewById(Long id);

    Review createReviewRequest(Restaurant restaurantId, String content, Double rating, Customer customer);

}

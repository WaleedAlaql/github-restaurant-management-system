package com.waleed.DTO;

import com.waleed.entity.Customer;
import lombok.Data;

@Data
public class CreateReviewRequest {

    private String content;
    private Double rating;
    private Customer customer;
}

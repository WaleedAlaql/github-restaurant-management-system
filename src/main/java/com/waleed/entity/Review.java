package com.waleed.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(
        name = "review"
)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "content",
            nullable = false
    )
    private String content;

    @Column(
            name = "rating",
            nullable = false
    )
    private Double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(
            name = "restaurant_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "restaurant_review_fk"
            )
    )
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_review_fk"
            )
    )
    private Customer customer;

}

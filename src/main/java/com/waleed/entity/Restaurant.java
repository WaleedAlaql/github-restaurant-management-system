package com.waleed.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(
        name = "restaurant"
)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "restaurant_name",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String restaurantName;

    @Column(
            name = "cuisine",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String cuisine;

    @Column(
            name = "address",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String address;

    @Column(
            name = "phone_number",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(
            mappedBy = "restaurant",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Menu> menuList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(
            mappedBy = "restaurant",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private List<Review> reviews = new ArrayList<>();
}

package com.waleed.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waleed.enums.DinnerMenu;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(
        name = "menu_item"
)
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "item_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "description",
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "price",
            nullable = false
    )
    private Double price;

    @Enumerated(EnumType.STRING)
    private DinnerMenu menuType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(
            name = "menu_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "menu_item_fk"
            )
    )
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(
            name = "restaurant_id",
//            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "restaurant_menu_item_fk"
            )
    )    private Restaurant restaurant;
}

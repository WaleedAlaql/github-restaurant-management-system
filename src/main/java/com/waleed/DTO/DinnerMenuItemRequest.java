package com.waleed.DTO;

import com.waleed.entity.Menu;
import lombok.Data;

@Data
public class DinnerMenuItemRequest {

    private String name;
    private String description;
    private Double price;
    private Menu menu;
}

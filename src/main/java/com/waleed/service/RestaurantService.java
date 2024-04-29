package com.waleed.service;

import com.waleed.entity.Menu;
import com.waleed.entity.Restaurant;
import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantById(Long id);

    Restaurant createRestaurant(Restaurant restaurant);

    Menu addMenuToRestaurant(Long restaurantId, Menu menu);
}

package com.waleed.controller;

import com.waleed.entity.Menu;
import com.waleed.entity.Restaurant;
import com.waleed.service.RestaurantServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

    private final RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("/create")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantService.createRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRestaurant);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<?> getRestaurantById(@PathVariable Long restaurantId){
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        return ResponseEntity.ok(restaurant);
    }

    @PutMapping("/update/{restaurantId}")
    public ResponseEntity<?> updateRestaurant(@PathVariable Long restaurantId, @RequestBody Restaurant restaurant){
        restaurantService.updateRestaurant(restaurantId, restaurant);
        return ResponseEntity.ok("Restaurant updated successfully");
    }

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<?> deleteRestaurantById(@PathVariable Long restaurantId){
        restaurantService.deleteRestaurantById(restaurantId);
        return ResponseEntity.ok("Restaurant deleted successfully");
    }

    @PostMapping("/{restaurantId}/add-menu")
    public Menu addMenuToRestaurant(@PathVariable Long restaurantId, @RequestBody Menu menu) {
        return restaurantService.addMenuToRestaurant(restaurantId, menu);
    }
}

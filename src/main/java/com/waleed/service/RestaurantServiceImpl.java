package com.waleed.service;

import com.waleed.entity.Menu;
import com.waleed.entity.Restaurant;
import com.waleed.exception.RestaurantNotFoundException;
import com.waleed.repository.MenuRepository;
import com.waleed.repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;
    private final MenuRepository menuRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant with id: " + id + " not found"));
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Long restaurantId, Restaurant updatedRestaurant){
        Restaurant existingRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant with id: " + restaurantId + " not found"));

        existingRestaurant.setRestaurantName(updatedRestaurant.getRestaurantName());
        existingRestaurant.setCuisine(updatedRestaurant.getCuisine());
        existingRestaurant.setAddress(updatedRestaurant.getAddress());
        existingRestaurant.setPhoneNumber(updatedRestaurant.getPhoneNumber());

        return restaurantRepository.save(existingRestaurant);
    }

    public void deleteRestaurantById(Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundException("Restaurant with id: " + restaurantId + " not found"));
        restaurantRepository.delete(restaurant);
    }

    public Menu addMenuToRestaurant(Long restaurantId, Menu menu) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            menu.setRestaurant(restaurant); // Set restaurant reference in Menu
            restaurant.getMenuList().add(menu); // Add menu to Restaurant's menuList
            restaurantRepository.save(restaurant); // Save the updated Restaurant entity (saves the menu as well due to cascade)
            return menuRepository.save(menu); // Optional, already saved through cascade
        } else {
            throw new RestaurantNotFoundException("Restaurant with id: " + restaurantId + " not found");
        }
    }
}

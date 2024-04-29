package com.waleed.service;

import com.waleed.entity.Menu;
import com.waleed.entity.MenuItem;
import com.waleed.entity.Restaurant;
import java.util.List;

public interface MenuItemService {

    List<MenuItem> getAllMenuItems();

    MenuItem createMenuItem(MenuItem menuItem);

    MenuItem getMenuItemById(Long id);

    MenuItem createDinnerMenuItem(Restaurant restaurantId, String name, String description, Double price, Menu menu);
}

package com.waleed.service;

import com.waleed.entity.Menu;
import com.waleed.entity.MenuItem;
import com.waleed.entity.Restaurant;
import com.waleed.enums.DinnerMenu;
import com.waleed.exception.MenuItemNotFoundException;
import com.waleed.repository.MenuItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuItemServiceImpl implements MenuItemService{

    private final MenuItemRepository menuItemRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem createMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem getMenuItemById(Long id) {
        return menuItemRepository.findById(id)
                .orElseThrow(() -> new MenuItemNotFoundException("Menu Item with id: " + id + " not found"));
    }

    public MenuItem updateMenuItem(Long menuItemId, MenuItem updatedMenuItem){
        MenuItem existingMenuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new MenuItemNotFoundException("Menu Item with id: " + menuItemId + " not found"));

        existingMenuItem.setName(updatedMenuItem.getName());
        existingMenuItem.setDescription(updatedMenuItem.getDescription());
        existingMenuItem.setPrice(updatedMenuItem.getPrice());
        return menuItemRepository.save(existingMenuItem);
    }

    public void deleteMenuItemById(Long menuItemId){
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new MenuItemNotFoundException("Menu Item with id: " + menuItemId + " not found"));
        menuItemRepository.delete(menuItem);
    }

    @Override
    public MenuItem createDinnerMenuItem(Restaurant restaurantId, String name, String description, Double price, Menu menu) {
        MenuItem menuItem = new MenuItem();
        menuItem.setRestaurant(restaurantId);
        menuItem.setName(name);
        menuItem.setDescription(description);
        menuItem.setPrice(price);
        menuItem.setMenuType(DinnerMenu.DINNER_MENU); // Set DinnerMenu type
        menuItem.setMenu(menu);
        return menuItemRepository.save(menuItem);
    }
}

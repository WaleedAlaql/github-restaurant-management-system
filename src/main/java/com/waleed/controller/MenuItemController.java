package com.waleed.controller;

import com.waleed.DTO.DinnerMenuItemRequest;
import com.waleed.entity.MenuItem;
import com.waleed.entity.Restaurant;
import com.waleed.service.MenuItemServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/menu-item")
public class MenuItemController {

    private final MenuItemServiceImpl menuItemService;

    public MenuItemController(MenuItemServiceImpl menuItemService) {
        this.menuItemService = menuItemService;
    }

    @PostMapping("/create")
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.createMenuItem(menuItem);
    }

    @GetMapping("/all")
    public List<MenuItem> getAllMenuItems() {
        return menuItemService.getAllMenuItems();
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<?> getMenuItemById(@PathVariable Long menuId){
        MenuItem menuItem = menuItemService.getMenuItemById(menuId);
        return ResponseEntity.ok(menuItem);
    }

    @PutMapping("/update/{menuItemId}")
    public ResponseEntity<?> updateMenuItem(@PathVariable Long menuItemId, @RequestBody MenuItem menuItem){
        menuItemService.updateMenuItem(menuItemId, menuItem);
        return ResponseEntity.ok("Menu Item updated successfully");
    }

    @DeleteMapping("/{menuItemId}")
    public ResponseEntity<?> deleteMenuItemById(@PathVariable Long menuItemId){
        menuItemService.deleteMenuItemById(menuItemId);
        return ResponseEntity.ok("Menu Item deleted successfully");
    }

    @PostMapping("/{restaurantId}/dinner")
    public MenuItem createDinnerMenuItem(@PathVariable Restaurant restaurantId, @RequestBody DinnerMenuItemRequest request) {
        return menuItemService.createDinnerMenuItem(restaurantId, request.getName(), request.getDescription(), request.getPrice(), request.getMenu());
    }
}

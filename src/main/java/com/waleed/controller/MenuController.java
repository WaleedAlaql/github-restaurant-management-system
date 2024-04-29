package com.waleed.controller;

import com.waleed.entity.Menu;
import com.waleed.service.MenuServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private final MenuServiceImpl menuService;

    public MenuController(MenuServiceImpl menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/create")
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        Menu savedMenu = menuService.createMenu(menu);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMenu);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Menu>> getAllMenus(){
        List<Menu> menus = menuService.getAllMenus();
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long menuId){
        Menu menu = menuService.getMenuById(menuId);
        return ResponseEntity.ok(menu);
    }

    @PutMapping("/update/{menuId}")
    public ResponseEntity<?> updateMenu(@PathVariable Long menuId, @RequestBody Menu menu){
        menuService.updateMenu(menuId, menu);
        return ResponseEntity.ok("Menu updated successfully");
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity<?> deleteMenuById(@PathVariable Long menuId){
        menuService.deleteMenuById(menuId);
        return ResponseEntity.ok("Menu deleted successfully");
    }
}

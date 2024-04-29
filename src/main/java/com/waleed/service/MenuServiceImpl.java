package com.waleed.service;

import com.waleed.entity.Menu;
import com.waleed.exception.MenuNotFoundException;
import com.waleed.repository.MenuRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu getMenuById(Long id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new MenuNotFoundException("Menu with id: " + id + " not found"));
    }

    public Menu updateMenu(Long menuId, Menu updatedMenu){
        Menu existingMenu = menuRepository.findById(menuId)
                .orElseThrow(() -> new MenuNotFoundException("Menu with id: " + menuId + " not found"));

        existingMenu.setMenuName(updatedMenu.getMenuName());
        return menuRepository.save(existingMenu);
    }

    public void deleteMenuById(Long menuId){
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new MenuNotFoundException("Menu with id: " + menuId + " not found"));
        menuRepository.delete(menu);
    }
}

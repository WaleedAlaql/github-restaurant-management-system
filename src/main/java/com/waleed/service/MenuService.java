package com.waleed.service;

import com.waleed.entity.Menu;
import java.util.List;

public interface MenuService {

    List<Menu> getAllMenus();

    Menu createMenu(Menu menu);

    Menu getMenuById(Long id);

}

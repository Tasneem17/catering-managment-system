package za.ac.cput.service;

import za.ac.cput.entity.Category;
import za.ac.cput.entity.Menu;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    Menu read (String id);
    boolean deletebyid(String id);

    Menu save(Menu menu);
    List<Menu> findAll();

}

package za.ac.cput.service;

import za.ac.cput.entity.Menu;
import za.ac.cput.service.IService;

import java.util.List;
import java.util.Optional;

public interface MenuService extends IService<Menu,String> {
    boolean deletebyid(String id);
    List<Menu> findall(Menu menu);

}

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Menu;
import za.ac.cput.repository.IMenuRepository;
import za.ac.cput.service.MenuService;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    private IMenuRepository menuRepository;

    @Autowired
   public MenuServiceImpl(IMenuRepository menuRepository)
   {
       this.menuRepository = menuRepository;
   }

   @Override
    public Menu save(Menu menu)
   {
       return  this.menuRepository.save(menu);
   }

    @Override
    public Menu read(String id)
    {
        return this.menuRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deletebyid(String id) {
        this.menuRepository.deleteById(id);
        return false;
    }
   @Override
    public List<Menu> findAll() {
        return this.menuRepository.findAll();
    }
}

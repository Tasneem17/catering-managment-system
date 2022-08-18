package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Menu;
import za.ac.cput.repository.IMenuRepository;
import za.ac.cput.service.MenuService;

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
    public Optional<Menu> read(String id)
    {
        return this.menuRepository.findById(id);
    }
    @Override
    public boolean delete(Menu menu)
    {
        this.menuRepository.delete(menu);
        return false;
    }


}

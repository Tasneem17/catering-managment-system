/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *service:BeverageMenuService
 */
package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.BeverageMenu;
import za.ac.cput.repository.IBeverageMenuRepository;
import za.ac.cput.service.BeverageMenuService;

import java.util.List;
import java.util.Optional;

@Service
public class BeverageMenuServiceimpl implements BeverageMenuService {
    private final IBeverageMenuRepository repository;
public BeverageMenuServiceimpl(IBeverageMenuRepository repository){
    this.repository = repository;
}
@Override
public BeverageMenu save (BeverageMenu beverageMenu){
    return this.repository.save(beverageMenu);
}
@Override
public Optional<BeverageMenu> read(String beverageName) {
    return this.repository.read(beverageName);
}
@Override
  public boolean delete(BeverageMenu beverageMenu){
    this.repository.delete(beverageMenu);
    return false;
}

    @Override
    public List<BeverageMenu> findAllBeverageName(String beverageName) {
        return this.repository.findAll();
    }

    @Override
    public void deleteBybeverageName(String beverageName) {

    }

    @Override
    public List<BeverageMenu> findAll() {
        return null;
    }
}

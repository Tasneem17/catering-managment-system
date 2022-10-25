/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *service:BeverageMenuService
 */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.BeverageMenu;
import za.ac.cput.repository.IBeverageMenuRepository;
import za.ac.cput.service.BeverageMenuService;

import java.util.List;
import java.util.Optional;

@Service
public class BeverageMenuServiceimpl implements BeverageMenuService {
    private final IBeverageMenuRepository beverageMenuRepository;
    @Autowired
    public BeverageMenuServiceimpl(IBeverageMenuRepository beverageMenuRepository){
    this.beverageMenuRepository = beverageMenuRepository;
}
@Override
public BeverageMenu save(BeverageMenu beverageMenu){
    return this.beverageMenuRepository.save(beverageMenu);
}

    @Override
    public List<BeverageMenu> findAllBeverageName(String beverageName) {
        return null;
    }

    @Override
public Optional<BeverageMenu> read(String beverageName) {
    return this.beverageMenuRepository.findById(beverageName);
}

    @Override
    public List<BeverageMenu> findAll() {
        return this.beverageMenuRepository.findAll();
    }

    @Override
    public void delete(BeverageMenu beverageMenu) {

    }

    @Override
    public boolean deleteBybeverageName(String beverageName) {
        this.beverageMenuRepository.deleteById(beverageName);
        return false;

    }
}

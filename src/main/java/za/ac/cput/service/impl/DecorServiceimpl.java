/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *service:DecorService
 */
package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;


import za.ac.cput.entity.Decor;
import za.ac.cput.repository.IDecorRepository;
import za.ac.cput.service.DecorService;

import java.util.List;
import java.util.Optional;

@Service
public class DecorServiceimpl implements DecorService {
    private final IDecorRepository repository;
    public DecorServiceimpl(IDecorRepository repository){
        this.repository = repository;
    }
    @Override
    public Decor save (Decor decor){
        return this.repository.save(decor);
    }
    @Override
    public Optional<Decor> read(String decorType) {
        return this.repository.read(decorType);
    }
    @Override
    public boolean delete(Decor decor){
        this.repository.delete(decor);
        return false;
    }

    @Override
    public List<Decor> findAllDecorType(String decorType) {
        return this.repository.findAll();
    }
}



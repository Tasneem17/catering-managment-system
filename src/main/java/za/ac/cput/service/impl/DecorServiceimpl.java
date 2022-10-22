/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *service:DecorService
 */
package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import za.ac.cput.entity.Decor;
import za.ac.cput.repository.IDecorRepository;
import za.ac.cput.service.DecorService;

import java.util.List;
import java.util.Optional;

@Service
public class DecorServiceimpl implements DecorService {
    private final IDecorRepository decorRepository;
    @Autowired
    public DecorServiceimpl(IDecorRepository  decorRepository){
        this. decorRepository =  decorRepository;
    }
    @Override
    public Decor save (Decor decor){
        return this. decorRepository.save(decor);
    }
    @Override
    public Optional<Decor> read(String decorType) {
        return this. decorRepository.findById(decorType);
    }
    @Override
    public boolean delete(Decor decor){
        this. decorRepository.delete(decor);
        return false;
    }

    @Override
    public List<Decor> findAllDecorType(String decorType) {
        return this. decorRepository.findAll();
    }

    @Override
    public List<Decor> findAll() {
        return null;
    }

    @Override
    public boolean deleteBydecorType(String decorType) {
        this.decorRepository.deleteById(decorType);
        return false;
    }
}



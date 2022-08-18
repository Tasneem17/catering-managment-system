/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *service:EquipmentService
 */
package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;

import za.ac.cput.entity.Equipment;
import za.ac.cput.repository.IEquipmentRepository;
import za.ac.cput.service.EquipmentService;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentServiceimpl implements EquipmentService {
    private final IEquipmentRepository repository;
    public EquipmentServiceimpl(IEquipmentRepository repository){
        this.repository = repository;
    }
    @Override
    public Equipment save (Equipment equipment){
        return this.repository.save(equipment);
    }
    @Override
    public Optional<Equipment> read(String equipmentID) {
        return this.repository.read(equipmentID);
    }
    @Override
    public boolean delete(Equipment equipment){
        this.repository.delete(equipment);
        return false;
    }

    @Override
    public List<Equipment> findAllEquipmentID(String equipmentID) {
        return this.repository.findAll();
    }
}


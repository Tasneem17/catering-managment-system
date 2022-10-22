/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *service:EquipmentChoiceServiceimpl
 */
package za.ac.cput.service.impl;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.EquipmentChoice;
import za.ac.cput.repository.IEquipmentChoiceRepository;
import za.ac.cput.service.EquipmentChoiceService;

import java.util.List;
import java.util.Optional;
@Service
public class EquipmentChoiceServiceimpl implements EquipmentChoiceService {
    private final IEquipmentChoiceRepository equipmentChoiceRepository;
    public EquipmentChoiceServiceimpl(IEquipmentChoiceRepository repository){
        this.equipmentChoiceRepository = repository;
    }
@Override
    public EquipmentChoice save(EquipmentChoice equipmentChoice){
        return this.equipmentChoiceRepository.save(equipmentChoice);
    }
@Override
    public Optional<EquipmentChoice> read(String choiceCustomer) {
        return this.equipmentChoiceRepository.findById(choiceCustomer);
    }
@Override
    public boolean delete(EquipmentChoice equipmentChoice){
        this.equipmentChoiceRepository.delete(equipmentChoice);
    return false;
}
@Override

    public List<EquipmentChoice> findAllChoiceCustomer(String choiceCustomer) {
        return this.equipmentChoiceRepository.findAll();
    }

    @Override
    public void deleteBychoiceCustomer(String choiceCustomer) {

    }

    @Override
    public List<EquipmentChoice> findAll() {
        return null;
    }
}




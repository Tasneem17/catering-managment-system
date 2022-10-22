
/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *service:EquipmentChoiceService
 */
package za.ac.cput.service;


import za.ac.cput.entity.EquipmentChoice;

import java.util.List;
import java.util.Optional;

public interface EquipmentChoiceService {
    EquipmentChoice save(EquipmentChoice equipmentChoice);

    Optional<EquipmentChoice> read(String choiceCustomer);

    boolean delete(EquipmentChoice equipmentChoice);

    List<EquipmentChoice> findAllChoiceCustomer(String choiceCustomer);

    void deleteBychoiceCustomer(String choiceCustomer);

    List<EquipmentChoice> findAll();
}

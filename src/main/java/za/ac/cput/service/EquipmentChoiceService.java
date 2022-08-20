
/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *service:EquipmentChoiceService
 */
package za.ac.cput.service;


import za.ac.cput.entity.EquipmentChoice;

import java.util.List;

public interface EquipmentChoiceService extends IService<EquipmentChoice,String> {
    List<EquipmentChoice> findAllChoiceCustomer(String choiceCustomer);

    void deleteBychoiceCustomer(String choiceCustomer);

    List<EquipmentChoice> findAll();
}

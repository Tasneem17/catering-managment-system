/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *service:IEquipmentService
 */
package za.ac.cput.service;

import za.ac.cput.entity.Equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentService {
    Equipment save(Equipment equipment);

    Optional<Equipment> read(String equipmentID);

    boolean delete(Equipment equipment);

    List<Equipment> findAllEquipmentID(String equipmentID);

    void deleteByequipmentID(String equipmentID);

    List<Equipment> findAll();
}

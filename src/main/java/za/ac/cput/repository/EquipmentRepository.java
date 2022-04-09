/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Repository: Equipment Repository
 */
package za.ac.cput.repository;
import za.ac.cput.entity.Equipment;

import java.util.HashSet;
import java.util.Set;

public class EquipmentRepository  implements IEquipment{
    private static EquipmentRepository  repository = null;
    private Set<Equipment> equipmentDB = null;

    private EquipmentRepository(){equipmentDB  = new HashSet<Equipment>();}

    public static   EquipmentRepository getRepository(){
        if (repository == null){
            repository = new  EquipmentRepository();
        }
        return repository;
    }

    @Override
    public  Equipment create( Equipment  equipment) {
        boolean success = equipmentDB.add(equipment);
        if (!success)
            return null;
        return equipment;
    }

    @Override
    public Equipment read(String equipmentID) {
        for (Equipment eq :equipmentDB) {
            if (eq.getEquipmentID().equals(equipmentID))
                return eq;
        }
        return null;

    }

    @Override
    public Equipment update(Equipment equipment){
        Equipment oldEquipment = read(equipment.getEquipmentID());
        if(oldEquipment != null){
            equipmentDB.remove(oldEquipment);
            equipmentDB.add(equipment);
            return equipment;
        }
        return null;
    }

    @Override
    public boolean delete(String equipmentID) {
        Equipment equipmentTODelete = read (equipmentID);
        if (equipmentTODelete == null)
            return false;
        equipmentDB.remove(equipmentTODelete);
        return true;
    }

    @Override
    public Set< Equipment > getAll() {
        return  equipmentDB;
    }
}



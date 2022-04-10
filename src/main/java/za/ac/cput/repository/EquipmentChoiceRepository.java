/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Repository: EquipmentChoice Repository
 */
package za.ac.cput.repository;


import za.ac.cput.entity.EquipmentChoice;

import java.util.HashSet;
import java.util.Set;

public class EquipmentChoiceRepository  implements IEquipmentChoice {
    private static EquipmentChoiceRepository repository = null;
    private Set<EquipmentChoice> equipmentChoiceDB = null;

    private EquipmentChoiceRepository(){
        equipmentChoiceDB  = new HashSet<EquipmentChoice>();
    }

    public static  EquipmentChoiceRepository getRepository(){
        if (repository == null){
            repository = new EquipmentChoiceRepository();
        }
        return repository;
    }

    @Override
    public EquipmentChoice create(EquipmentChoice equipmentChoice) {
        boolean success = equipmentChoiceDB.add(equipmentChoice);
        if (!success)
            return null;
        return equipmentChoice;
    }

    @Override
    public EquipmentChoice read(String choiceCustomer) {
        for (EquipmentChoice e :equipmentChoiceDB) {
            if (e.getChoiceCustomer().equals(choiceCustomer))
                return e;
        }
        return null;

    }

    @Override
    public EquipmentChoice update(EquipmentChoice equipmentChoice){
        EquipmentChoice oldEquipmentChoice = read(equipmentChoice.getChoiceCustomer());
        if(oldEquipmentChoice != null){
            equipmentChoiceDB.remove(oldEquipmentChoice);
            equipmentChoiceDB.add(equipmentChoice);
            return equipmentChoice;
        }
        return null;
    }

    @Override
    public boolean delete(String choiceCustomer) {
        EquipmentChoice EquipmentChoiceTODelete = read (choiceCustomer);
        if (EquipmentChoiceTODelete == null)
            return false;
        equipmentChoiceDB.remove(EquipmentChoiceTODelete);
        return true;
    }


    @Override
    public Set< EquipmentChoice > getAll() {
        return  equipmentChoiceDB;
    }
}



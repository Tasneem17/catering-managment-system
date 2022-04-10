/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Test:Equipment Choice
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EquipmentChoice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class EquipmentChoiceFactoryTest {

    @Test
    void createEquipmentChoice(){

   EquipmentChoice equipmentChoice = EquipmentChoiceFactory.createEquipmentChoice("Yes","No");
        assertNotNull(equipmentChoice);
        System.out.println(equipmentChoice);
    }


}


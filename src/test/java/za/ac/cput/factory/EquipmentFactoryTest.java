/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Test:EquipmentFactory
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Equipment;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class EquipmentFactoryTest {
    @Test

    void createEquipment(){
      Equipment equipment = EquipmentFactory.createEquipment("002","Round Chair","50","R1000");
        assertNotNull(equipment);
        System.out.println(equipment);
    }

}


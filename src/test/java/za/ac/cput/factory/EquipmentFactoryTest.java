/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Test:EquipmentFactory
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Equipment;
import za.ac.cput.entity.Equipment;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentFactoryTest {
    @Test
    public void buildWithSuccess() {

        Equipment equipment = EquipmentFactory
                .createEquipment("Table Cloth","","","");
        System.out.println(equipment);
        assertNotNull(equipment);
    }

    @Test
    public void buildWithError() {

        Exception  exception = assertThrows(IllegalArgumentException.class,() ->
               EquipmentFactory
                       .createEquipment("null","","",""));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame( "EquipmentId is required!",exceptionMessage );
    }

}
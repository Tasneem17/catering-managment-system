/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Test:Equipment Choice
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EquipmentChoice;


import static org.junit.jupiter.api.Assertions.*;

class EquipmentChoiceFactoryTest {
    @Test
    public void buildWithSuccess() {

        EquipmentChoice equipmentChoice = EquipmentChoiceFactory
                .createEquipmentChoice("Yes","");
        System.out.println(equipmentChoice);
        assertNotNull(equipmentChoice);
    }

    @Test
    public void buildWithError() {

        Exception  exception = assertThrows(IllegalArgumentException.class,() ->
                EquipmentChoiceFactory
                        .createEquipmentChoice("null",""));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame( "Equipment Choice required!",exceptionMessage );
    }

}
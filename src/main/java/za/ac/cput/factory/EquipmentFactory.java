/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Factory:Equipment Choice Factory
 */
package za.ac.cput.factory;
import za.ac.cput.entity.Equipment;
import za.ac.cput.util.Helper;

public class EquipmentFactory {
    public  static Equipment createEquipment(String equipmentID, String equipmentDescription, String equipmentQuantity, String equipmentPrice){




        if (Helper.isNullorEmpty(equipmentID)|| Helper.isNullorEmpty(equipmentDescription)|| Helper.isNullorEmpty( equipmentQuantity) || Helper.isNullorEmpty(equipmentPrice))
            return null;

        if (equipmentID.equals("")||equipmentID == null)
            return null;
        if (equipmentDescription.equals("")||equipmentDescription== null)
            return null;
        if(equipmentQuantity.equals("")|| equipmentQuantity== null)
            return null;
        if (equipmentPrice.equals("")|| equipmentPrice == null)
            return null;


        return new Equipment.Builder().setEquipmentID(equipmentID)
                .setEquipmentDescription(equipmentDescription)
                .setEquipmentQuantity(equipmentQuantity)
                .setEquipmentPrice(equipmentPrice)
                .build();

    }
}


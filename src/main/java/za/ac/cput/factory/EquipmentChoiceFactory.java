/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Factory:Equipment Choice Factory
 */

package za.ac.cput.factory;
import za.ac.cput.entity.EquipmentChoice;
import za.ac.cput.util.Helper;

public class EquipmentChoiceFactory {
    public  static EquipmentChoice createEquipmentChoice(String choiceCustomer, String choiceCompany){




        if (Helper.isNullorEmpty(choiceCustomer)|| Helper.isNullorEmpty(choiceCompany))
            return null;

        if (choiceCustomer.equals("")||choiceCustomer == null)
            return null;
        if (choiceCompany.equals("")||choiceCompany== null)
            return null;



        return new EquipmentChoice.Builder().setChoiceCustomer(choiceCustomer)
                .setChoiceCompany(choiceCompany)
                .build();

    }
}


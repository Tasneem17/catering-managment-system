package za.ac.cput.factory;
/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */

import za.ac.cput.entity.Food;
import za.ac.cput.util.Helper;

public class FoodFactory {

    public static Food createFood( String  Food_ID,String Food_Name, String Food_Description,
                                  String Food_Quantity,
                                  double Food_Price) {
        if (Helper.isNullorEmpty(Food_Name) ||
                Helper.isNullorEmpty(Food_Description)||
                Helper.isNullorEmpty(Food_Quantity))
            return null;
        if (Helper.isEmpty(Food_Price))
            return null;

        return new Food.Builder().setFood_ID(Food_ID).setFood_Name(Food_Name)
                .setFood_Description(Food_Description)
                .setFood_Quantity(Food_Quantity).setFood_Price(Food_Price)
                .build();
    }
}

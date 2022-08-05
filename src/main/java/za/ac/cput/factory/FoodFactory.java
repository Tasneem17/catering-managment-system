package za.ac.cput.factory;
/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */

import za.ac.cput.entity.Food;
import za.ac.cput.helper.RepoHelper;

public class FoodFactory {

    public static Food createFood(String Food_Name, String Food_Description,
                                  String Food_Quantity,
                                  double Food_Price) {
        if (RepoHelper.isNullorEmpty(Food_Name) ||
                RepoHelper.isNullorEmpty(Food_Description)||
                RepoHelper.isNullorEmpty(Food_Quantity))
            return null;
        if (RepoHelper.isEmpty(Food_Price))
            return null;

        return new Food.Builder().setFood_ID(RepoHelper.idgenerate()).setFood_Name(Food_Name)
                .setFood_Description(Food_Description)
                .setFood_Quantity(Food_Quantity)
                .build();
    }
}

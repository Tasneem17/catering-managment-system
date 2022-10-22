/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Factory :BeverageMenu Factory
 */

package za.ac.cput.factory;

import za.ac.cput.entity.BeverageMenu;
import za.ac.cput.util.Helper;

public class BeverageMenuFactory {
    public  static BeverageMenu createBeverageMenu(String beverageName, String price, String description, String quantity,String availability){

        if (Helper.isNullorEmpty(beverageName)|| Helper.isNullorEmpty(price)|| Helper.isNullorEmpty(description) || Helper.isNullorEmpty(availability)|| Helper.isNullorEmpty(quantity))
            return null;

        if (price.equals("")||price == null)
            return null;
        if (description.equals("")||description== null)
            return null;
        if(quantity.equals("")|| quantity== null)
            return null;
        if (availability.equals("")|| availability == null)
            return null;


        return new BeverageMenu.Builder().setBeverageName(beverageName)
                .setPrice(price)
                .setDescription(description)
                .setQuantity(quantity)
                .setAvailability(availability)
                .build();

    }


}



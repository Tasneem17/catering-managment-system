/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Factory:Decor Factory
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Decor;
import za.ac.cput.util.Helper;

public class DecorFactory {


    public  static Decor build(String decorType, String decorSize, String decorQuantity, String cost){


        if (Helper.isNullorEmpty(decorType)|| Helper.isNullorEmpty(decorSize)|| Helper.isNullorEmpty( decorQuantity) || Helper.isNullorEmpty(cost))
            return null;

        if (decorType.equals("")||decorType == null)
            return null;
        if (decorSize.equals("")||decorSize== null)
            return null;
        if(decorQuantity.equals("")|| decorQuantity== null)
            return null;
        if (cost.equals("")|| cost == null)
            return null;


        return new Decor.Builder().setDecorType(decorType)
                .setDecorSize(decorSize)
                .setDecorQuantity(decorSize)
                .setCost(cost)
                .build();

    }
}


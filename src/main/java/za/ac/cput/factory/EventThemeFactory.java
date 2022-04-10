/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.factory;

import za.ac.cput.entity.EventTheme;
import za.ac.cput.util.Helper;

public class EventThemeFactory {
    public static EventTheme createEvent(String Event_id,String Theme_Description){
        if (Helper.isNullorEmpty(Event_id)|| Helper.isNullorEmpty(Theme_Description))
            return null;

        if (Event_id.equals("")||Event_id == null)
            return null;
        if (Theme_Description.equals("")||Theme_Description== null)
            return null;


        return new EventTheme.Builder().setEventId(Event_id)
                .setThemeDescription(Theme_Description)
                .build();

    }
}

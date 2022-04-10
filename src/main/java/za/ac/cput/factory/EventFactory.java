/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Event;
import za.ac.cput.Util.Helper;

public class EventFactory {
    public static Event createEvent(String Event_id,String Event_name,String Event_description,String Event_duration){
        if (Helper.isNullorEmpty(Event_id)|| Helper.isNullorEmpty(Event_name)|| Helper.isNullorEmpty(Event_description) || Helper.isNullorEmpty(Event_duration))
            return null;

        if (Event_id.equals("")||Event_id == null)
            return null;
        if (Event_name.equals("")||Event_name== null)
            return null;
        if(Event_description.equals("")|| Event_description== null)
            return null;
        if (Event_duration.equals("")|| Event_duration == null)
            return null;

        return new Event.Builder().setEventId(Event_id)
                .setEventName(Event_name)
                .setEventDescription(Event_description)
                .setEventDuration(Event_duration)
                .build();

    }
}

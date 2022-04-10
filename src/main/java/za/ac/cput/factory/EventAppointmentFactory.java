/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */


package za.ac.cput.factory;

import za.ac.cput.entity.EventAppointment;
import za.ac.cput.Util.Helper;

public class EventAppointmentFactory {
    public static EventAppointment createEventAppointment(String event_id, String appointment_id){
        if (Helper.isNullorEmpty(event_id)|| Helper.isNullorEmpty(appointment_id))
            return null;

        if (event_id.equals("")||event_id == null)
            return null;
        if (appointment_id.equals("")||appointment_id== null)
            return null;

        return new EventAppointment.Builder().setEventId(event_id)
                .setAppointmentId(appointment_id)
                .build();

    }
}

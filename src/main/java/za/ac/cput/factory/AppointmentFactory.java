package za.ac.cput.factory;

import za.ac.cput.entity.Appointment;
import za.ac.cput.util.Helper;

public class AppointmentFactory {
    public static Appointment build(String appointment_id,String appointment_date,String appointment_location,String appointment_time,String appointment_NumberOfGuests){
        if (Helper.isNullorEmpty(appointment_id)|| Helper.isNullorEmpty(appointment_date)|| Helper.isNullorEmpty( appointment_location) || Helper.isNullorEmpty(appointment_time) || Helper.isNullorEmpty(appointment_NumberOfGuests))
            return null;

        if (appointment_id.equals("")||appointment_id == null)
            return null;
        if (appointment_date.equals("")||appointment_date== null)
            return null;
        if(appointment_location.equals("")|| appointment_location== null)
            return null;
        if (appointment_time.equals("")|| appointment_time == null)
            return null;
        if (appointment_NumberOfGuests.equals("")|| appointment_NumberOfGuests == null)
            return null;

        return new Appointment.Builder().setAppointment_id(appointment_id)
                .setAppointment_date(appointment_date)
                .setAppointment_location(appointment_location)
                .setAppointment_time(appointment_time)
                .setAppointment_NumberOfGuest(appointment_NumberOfGuests)
                .build();

    }
}


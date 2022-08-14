package za.ac.cput.entity;

import org.junit.jupiter.api.Test;

public class AppointmentTest {
    @Test
    public void Test() {
        Appointment appointment = new  Appointment.Builder().setAppointment_id("1")
                .setAppointment_date("22 January")
                .setAppointment_location("Sea Point ")
                .setAppointment_time("20:00")
                .setAppointment_NumberOfGuest("50")
                .build();

        System.out.println( appointment);
    }
}


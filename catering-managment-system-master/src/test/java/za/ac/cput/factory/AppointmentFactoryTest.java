package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Appointment;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentFactoryTest {

    @Test
    public void test(){
        Appointment appointment = AppointmentFactory.createAppointment("001","22/01/2022","Cape Town","12:00","50");
        assertNotNull(appointment);
        System.out.println(appointment);

    }
}
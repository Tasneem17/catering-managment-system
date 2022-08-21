package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Appointment;
import za.ac.cput.entity.EventStatus;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentFactoryTest {

    @Test
    public void buildWithSuccess() {

        Appointment appointment = AppointmentFactory
                .build("001","active","","","");
        System.out.println(appointment);
        assertNotNull(appointment);
    }

    @Test
    public void buildWithError() {

        Exception  exception = assertThrows(IllegalArgumentException.class,() ->
                AppointmentFactory
                        .build("null","","","",""));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame( "appointment ID is required!",exceptionMessage );
    }
}
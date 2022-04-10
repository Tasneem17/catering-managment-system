/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EventAppointment;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class EventAppointmentFactoryTest {
    @Test

    void createEvent(){
        EventAppointment eventAppointment = EventAppointmentFactory.createEventAppointment("No23","April 21st @15:45");
        assertNotNull(eventAppointment);
        System.out.println(eventAppointment);
    }

}

/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.EventAppointment;
import za.ac.cput.factory.EventAppointmentFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class EventAppointmentRepositoryTest {
    private static EventAppointmentRepository repository = EventAppointmentRepository.getRepository();
    private static EventAppointment eventAppointment = EventAppointmentFactory.createEventAppointment("No23","April 21st @15:45");

    @Test
    void l_create() {
        EventAppointment created = repository.create(eventAppointment);
        assertEquals(eventAppointment.getEventId(),created.getEventId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        EventAppointment read = repository.read(eventAppointment.getEventId());
        System.out.println("Read:" + read);
    }

    @Test
    void n_update() {
        EventAppointment updated = new EventAppointment.Builder().copy(eventAppointment).setAppointmentId("April 21st @15:45")
                .setAppointmentId("April 21st @15:45")
                .build();
        // assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void d_delete() {
        repository.delete(eventAppointment.getEventId());
        assertNotNull(repository);
    }

    @Test
    void p_getAll() {
        System.out.println("Show all :");
        System.out.println(repository.getAll());

    }
}
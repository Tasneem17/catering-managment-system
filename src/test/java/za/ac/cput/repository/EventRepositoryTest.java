/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.repository;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Event;
import za.ac.cput.factory.EventFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class EventRepositoryTest {
    private static EventRepository repository = EventRepository.getRepository();
    private static Event event = EventFactory.createEvent("No16","Davids Birthday","Davids 21st","5hrs");

    @Test
    void l_create() {
        Event created = repository.create(event);
        assertEquals(event.getEventName(),created.getEventName());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        Event read = repository.read(event.getEventId());
        System.out.println("Read:" + read);
    }

    @Test
    void n_update() {
        Event updated = new Event.Builder().copy(event).setEventDescription("Davids 21st")
                .setEventDescription("Davids 21st")
                .build();
        // assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void d_delete() {
        repository.delete(event.getEventName());
        assertNotNull(repository);
    }

    @Test
    void p_getAll() {
        System.out.println("Show all :");
        System.out.println(repository.getAll());

    }
}
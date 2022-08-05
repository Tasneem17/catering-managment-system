/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.repository;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.EventTheme;
import za.ac.cput.factory.EventThemeFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class EventThemeRepositoryTest {
    private static EventThemeRepository repository = EventThemeRepository.getRepository();
    private static EventTheme eventTheme = EventThemeFactory.createEvent("No26","Denim Party");

    @Test
    void l_create() {
        EventTheme created = repository.create(eventTheme);
        assertEquals(eventTheme.getEventId(),created.getEventId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        EventTheme read = repository.read(eventTheme.getEventId());
        System.out.println("Read:" + read);
    }

    @Test
    void n_update() {
        EventTheme updated = new EventTheme.Builder().copy(eventTheme).setThemeDescription("Denim Party")
                .setThemeDescription("Denim Party")
                .build();
        // assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void d_delete() {
        repository.delete(eventTheme.getEventId());
        assertNotNull(repository);
    }

    @Test
    void p_getAll() {
        System.out.println("Show all :");
        System.out.println(repository.getAll());

    }
}
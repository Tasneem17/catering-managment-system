/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Test: BeverageMenuRepository
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.BeverageMenu;
import za.ac.cput.factory.BeverageMenuFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class BeverageMenuRepositoryTest {
    private static BeverageMenuRepository repository = BeverageMenuRepository.getRepository();
    private static BeverageMenu beverageMenu = BeverageMenuFactory.createBeverageMenu("Red Explosion","R70","Cranberry","40","80");

    @Test
    void l_create() {
        BeverageMenu created = repository.create(beverageMenu);
        assertEquals(beverageMenu.getBeverageName(),created.getBeverageName());
        System.out.println("Create: " + created);
    }

    @Test
    void m_read() {
        BeverageMenu read = repository.read(beverageMenu.getBeverageName());
        assertNotNull(read);
        System.out.println("Read :"+ read);
    }

    @Test
    void n_update() {
        BeverageMenu updated = new BeverageMenu.Builder().copy(beverageMenu).setBeverageName("Purple")
                .setDescription("Bubbles")
                .build();
    // assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void o_delete() {
        boolean success = repository.delete(beverageMenu.getBeverageName());
        assertTrue(success);
        System.out.println("Delete" + success);
    }

    @Test
    void p_getAll() {
        System.out.println("Show all :");
        System.out.println(repository.getAll());

    }
}
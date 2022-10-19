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
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.BeverageMenu;
import za.ac.cput.factory.BeverageMenuFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class BeverageMenuRepositoryTest {
    private static BeverageMenu beverageMenu = BeverageMenuFactory.build("Orange ","R20.00","oranges","2","5");
    @Autowired private  IBeverageMenuRepository repository;

    @Test
    void l_create() {
        BeverageMenu created = repository.create(beverageMenu);
        assertEquals(beverageMenu.getBeverageName(),created.getBeverageName());
        System.out.println("Create: " + created);
    }

    @Test
    void m_read() {
        Optional<BeverageMenu> read = repository.read(beverageMenu.getBeverageName());
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
        this.repository.save(this.beverageMenu);
        List<BeverageMenu> beverageMenuList= this.repository.findAll();
        assertEquals(0,beverageMenuList.size());
    }

    @Test
    void p_getAll() {
        System.out.println("Show all :");
        System.out.println(repository.getAll());

    }
}
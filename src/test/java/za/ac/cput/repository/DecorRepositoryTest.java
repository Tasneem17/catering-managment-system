/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Repository:DecorRepository
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Decor;
import za.ac.cput.factory.DecorFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class DecorRepositoryTest {
    private static Decor decor = DecorFactory.build("Center Piece", "Large", "50", "R20");
    private static IDecorRepository repository;

    @Test
    void l_create() {
        Decor created = repository.create(decor);
        assertEquals(decor.getDecorType(),created.getDecorType());
        System.out.println("Create: " + created);
    }

    @Test
    void m_read() {
        Optional<Decor> read = repository.read(decor.getDecorType());
        assertNotNull(read);
        System.out.println("Read :"+ read);
    }

    @Test
    void n_update() {
        Decor updated = new Decor.Builder().copy(decor).setDecorType("Chair Covers")
                .setDecorSize("Small")
                .setDecorQuantity("23")
                .setCost("R60")
                .build();
        //assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void o_delete() {

        this.repository.save(this.decor);
        List<Decor> decorList= this.repository.findAll();
        assertEquals(0,decorList.size());
    }

    @Test
    void p_getAll() {
        System.out.println("Show all :");
        System.out.println(repository.getAll());

    }
}
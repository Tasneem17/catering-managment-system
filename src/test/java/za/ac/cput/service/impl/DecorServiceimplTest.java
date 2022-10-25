/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Test:DecorServiceimpl Test
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.RunCateringManagementSystem;
import za.ac.cput.entity.Decor;
import za.ac.cput.factory.DecorFactory;
import za.ac.cput.service.DecorService;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = RunCateringManagementSystem.class)
class DecorServiceimplTest {

    private final Decor decor = DecorFactory
            .createDecor("test-bev-name","price","","");
    @Autowired
    private DecorService service;
    @Test
    void save() {
        Decor saved = this.service.save(this.decor);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.decor, saved)
        );
    }


    @Test
    void read() {
        Optional<Decor> read = this.service.read(this.decor.getDecorType());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(this.decor, read.get())
        );
    }


    @Test
    void delete() {
        this.service.delete(this.decor);
    }

    @Test
    void findAllDecorType() {
        String decorType = this.decor.getDecorType();
        List<Decor> decorList
                = this.service.findAllDecorType(decorType);
        System.out.println(decorList);
        assertSame(0 ,decorList.size());
    }
}
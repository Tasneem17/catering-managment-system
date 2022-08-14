/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Test:BeverageMenuService Test
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.RunCateringManagementSystem;
import za.ac.cput.entity.BeverageMenu;
import za.ac.cput.factory.BeverageMenuFactory;
import za.ac.cput.service.BeverageMenuService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = RunCateringManagementSystem.class)
class BeverageMenuServiceimplTest {

    private final BeverageMenu beverageMenu = BeverageMenuFactory
            .build("test-bev-name","price","","","");
 @Autowired
private BeverageMenuService service;
    @Test
    void save() {
        BeverageMenu saved = this.service.save(this.beverageMenu);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.beverageMenu, saved)
        );
    }


    @Test
    void read() {
        Optional<BeverageMenu> read = this.service.read(this.beverageMenu.getBeverageName());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(this.beverageMenu, read.get())
        );
    }


    @Test
    void delete() {
        this.service.delete(this.beverageMenu);
    }

    @Test
    void findAllBeverageName() {
        String beverageName = this.beverageMenu.getBeverageName();
        List<BeverageMenu> beverageMenuListList
                = this.service.findAllBeverageName(beverageName);
        System.out.println(beverageMenuListList);
        assertSame(0 ,beverageMenuListList.size());
    }
}
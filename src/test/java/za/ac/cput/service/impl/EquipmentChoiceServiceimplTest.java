/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Test:EquipmentChoiceService
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.RunCateringManagementSystem;
import za.ac.cput.entity.EquipmentChoice;
import za.ac.cput.factory.EquipmentChoiceFactory;
import za.ac.cput.service.EquipmentChoiceService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = RunCateringManagementSystem.class)
class EquipmentChoiceServiceimplTest {
    private final EquipmentChoice equipmentChoice = EquipmentChoiceFactory
            .createEquipmentChoice("test-bev-name","price");
    @Autowired
    private EquipmentChoiceService service;
    @Test
    void save() {
        EquipmentChoice saved = this.service.save(this.equipmentChoice);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.equipmentChoice, saved)
        );
    }


    @Test
    void read() {
        Optional<EquipmentChoice> read = this.service.read(this.equipmentChoice.getChoiceCustomer());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(this.equipmentChoice, read.get())
        );
    }


    @Test
    void delete() {
        this.service.delete(this.equipmentChoice);

    }
    @Test
    void findAllChoiceCustomer() {
        String choiceCustomer = this.equipmentChoice.getChoiceCustomer();
        List<EquipmentChoice> equipmentChoiceList
                = this.service.findAllChoiceCustomer(choiceCustomer);
        System.out.println(equipmentChoiceList);
        assertSame(0 ,equipmentChoiceList.size());
    }
}
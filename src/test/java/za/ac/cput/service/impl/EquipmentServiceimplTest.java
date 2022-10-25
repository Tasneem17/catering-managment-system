/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Test:EquipmentService
 */
package za.ac.cput.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.RunCateringManagementSystem;
import za.ac.cput.entity.Equipment;
import za.ac.cput.factory.EquipmentFactory;
import za.ac.cput.service.EquipmentService;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = RunCateringManagementSystem.class)
class EquipmentServiceimplTest {
    private final Equipment equipment = EquipmentFactory
            .createEquipment("test-bev-name","price","","");
    @Autowired
    private EquipmentService service;

    @Test
    void save() {
        Equipment saved = this.service.save(this.equipment);
        assertAll(
                () -> assertNotNull(saved),
                () -> assertEquals(this.equipment, saved)
        );
    }


    @Test
    void read() {
        Optional<Equipment> read = this.service.read(this.equipment.getEquipmentID());
        System.out.println(read);
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertSame(this.equipment, read.get())
        );
    }


    @Test
    void delete() {
        this.service.delete(this.equipment);

    }
    @Test
    void findAllEquipmentID() {
        String equipmentID = this.equipment.getEquipmentID();
        List<Equipment> equipmentList
                = this.service.findAllEquipmentID(equipmentID);
        System.out.println(equipmentList);
        assertSame(0 ,equipmentList.size());
    }
}
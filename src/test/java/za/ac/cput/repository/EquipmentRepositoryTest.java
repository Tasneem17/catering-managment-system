/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Repository:EquipmentRepository
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Equipment;
import za.ac.cput.factory.EquipmentFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class EquipmentRepositoryTest {

    private static Equipment  equipment = EquipmentFactory.build("022", "Small Table", "20", "R200");
    private static IEquipmentRepository repository ;

    @Test
    void l_create() {
     Equipment created = repository.create(equipment);
        assertEquals(equipment.getEquipmentID(),created.getEquipmentID());
        System.out.println("Create: " + created);
    }

    @Test
    void m_read() {
        Optional< Equipment> read =this.repository.read(this.equipment.getEquipmentID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()-> assertEquals(this.equipment,read.get())
        );
    }

    @Test
    void n_update() {
       Equipment updated = new Equipment.Builder().copy(equipment).setEquipmentID("003")
               .setEquipmentDescription("Large Chair")
                .build();
      //  assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void o_delete() {
        this.repository.save(this.equipment);
        List<Equipment> equipmentList= this.repository.findAll();
        assertEquals(0,equipmentList.size());
    }

    @Test
    void p_getAll() {
        System.out.println("Show all :");
        System.out.println(repository.getAll());

    }
}
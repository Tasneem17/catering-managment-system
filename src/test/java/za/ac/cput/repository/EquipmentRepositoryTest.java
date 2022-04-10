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
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class EquipmentRepositoryTest {

    private static EquipmentRepository repository = EquipmentRepository.getRepository();
    private static Equipment equipment = EquipmentFactory.createEquipment("022", "Small Table", "20", "R200");

    @Test
    void l_create() {
     Equipment created = repository.create(equipment);
        assertEquals(equipment.getEquipmentID(),created.getEquipmentID());
        System.out.println("Create: " + created);
    }

    @Test
    void m_read() {
        Equipment read = repository.read(equipment.getEquipmentID());
        assertNotNull(read);
        System.out.println("Read :"+ read);
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
        boolean success = repository.delete(equipment.getEquipmentID());
        assertTrue(success);
        System.out.println("Delete" + success);
    }

    @Test
    void p_getAll() {
        System.out.println("Show all :");
        System.out.println(repository.getAll());

    }
}
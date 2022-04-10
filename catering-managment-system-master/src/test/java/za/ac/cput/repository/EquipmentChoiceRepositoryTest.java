/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Repository: EquipmentChoiceRepository Test
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.EquipmentChoice;
import za.ac.cput.factory.EquipmentChoiceFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class EquipmentChoiceRepositoryTest {
    private static EquipmentChoiceRepository repository = EquipmentChoiceRepository.getRepository();
    private static EquipmentChoice equipmentChoice = EquipmentChoiceFactory.createEquipmentChoice("No", "Yes");

    @Test
    void l_create() {
      EquipmentChoice created = repository.create(equipmentChoice);
        assertEquals(equipmentChoice.getChoiceCustomer(),created.getChoiceCustomer());
        System.out.println("Create: " + created);
    }

    @Test
    void m_read() {
        EquipmentChoice read = repository.read(equipmentChoice.getChoiceCustomer());
       assertNotNull(read);
        System.out.println("Read :"+ read);
    }

    @Test
    void n_update() {
        EquipmentChoice updated = new EquipmentChoice.Builder().copy(equipmentChoice).setChoiceCustomer("Yes")
                .setChoiceCompany("No")
                .build();
        // assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void o_delete() {
        boolean success = repository.delete(equipmentChoice.getChoiceCustomer());
        assertTrue(success);
        System.out.println("Delete" + success);
    }

    @Test
    void p_getAll() {
        System.out.println("Show all :");
        System.out.println(repository.getAll());

    }
}
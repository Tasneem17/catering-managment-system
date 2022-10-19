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

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class EquipmentChoiceRepositoryTest {
    private static EquipmentChoice equipmentChoice = EquipmentChoiceFactory.build("No", "Yes");
    private static IEquipmentChoiceRepository repository ;

    @Test
    void l_create() {
      EquipmentChoice created = repository.create(equipmentChoice);
        assertEquals(equipmentChoice.getChoiceCustomer(),created.getChoiceCustomer());
        System.out.println("Create: " + created);
    }

    @Test
    void m_read() {

        Optional<EquipmentChoice> read =this.repository.read(this.equipmentChoice.getChoiceCustomer());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()-> assertEquals(this.equipmentChoice,read.get())
        );
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
        this.repository.save(this.equipmentChoice);
        List<EquipmentChoice> equipmentChoiceList= this.repository.findAll();
        assertEquals(0,equipmentChoiceList.size());
    }

    @Test
    void p_getAll() {
        System.out.println("Show all :");
        System.out.println(repository.getAll());

    }
}
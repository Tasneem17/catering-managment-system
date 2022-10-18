/* ContactTypeServiceImplTest.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.ContactType;
import za.ac.cput.factory.ContactTypeFactory;
import java.util.Optional;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class ContactTypeServiceImplTest {
    @Autowired
    private ContactTypeServiceImpl contactTypeService;
    private ContactType contactType1;
    private ContactType contactType2;

    @Test
    @Order(1)
    void setUp() {
        contactType1 = ContactTypeFactory.createContactType("218", "Marcel February", "Customer");
        assertNotNull(contactType1);
        System.out.println(contactType1);
        contactType2 = ContactTypeFactory.createContactType("003", "Jason Goliath", "Customer");
        assertNotNull(contactType2);
        System.out.println(contactType2);
    }

    @Test
    @Order(2)
    void save() {
        ContactType created1 = contactTypeService.save(contactType1);
        assertNotNull(created1);
        System.out.println("created:" + created1);
        ContactType created2 = contactTypeService.save(contactType2);
        assertNotNull(created2);
        System.out.println("created:" + created2);
    }

    @Test
    @Order(3)
    void read() {
        Optional<ContactType> read = contactTypeService.read(contactType1.getContactTypeId());
        assertEquals(read.get(), contactType1.getContactTypeId());
        System.out.println("Read:" + read);
    }

    @Test
    @Order(5)
    void delete() {
        boolean success = contactTypeService.deleteById(String.valueOf(this.contactType2));
        assertTrue(success);
        System.out.println("Deleted:" + success);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println("Get All:");
        System.out.println(contactTypeService.getAll());
    }
}

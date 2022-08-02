/* ContactTypeRepositoryTest.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/


package za.ac.cput.repository;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.ContactType;
import za.ac.cput.factory.ContactTypeFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

public class ContactTypeRepositoryTest {
    private static ContactTypeRepository repository = ContactTypeRepository.getRepository();
    private static ContactType contactType = ContactTypeFactory.createContactType("445", "Mike Scott", "Customer");

    @Test
    void l_create() {
        ContactType created = repository.create(contactType);
        assertEquals(contactType.getContactTypeId(),created.getContactTypeId());
        System.out.println("Create: " + created);
    }

    @Test
    void m_read() {
        ContactType read = repository.read(contactType.getContactTypeId());
        assertNotNull(read);
        System.out.println("Read :"+ read);
    }

    @Test
    void n_update() {
        ContactType updated = new ContactType.Builder().copy(contactType).setContactTypeId("223")
                .setContactTypeName("John Smith")
                .build();
        System.out.println("Updated: "+ updated);
    }

    @Test
    void o_delete() {
        boolean success = repository.delete(contactType.getContactTypeId());
        assertTrue(success);
        System.out.println("Delete" + success);
    }

    @Test
    void p_getAll() {
        System.out.println("Show all :");
        System.out.println(repository.getAll());

    }
}

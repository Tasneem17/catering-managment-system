/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.UserContact;
import za.ac.cput.factory.UserContactFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)

class UserContactRepositoryTest {
    private static UserContactRepository repository = UserContactRepository.getRepository();
    private static UserContact userContact = UserContactFactory.createUserContact("9687156985658","E-mail","219098765@mycput.ac.za");

    @Test
    void l_create() {
        UserContact created = repository.create(userContact);
        assertEquals(userContact.getUserId(),created.getUserId());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read() {
        UserContact read = repository.read(userContact.getUserId());
        System.out.println("Read:" + read);
    }

    @Test
    void n_update() {
        UserContact updated = new UserContact.Builder().copy(userContact).setContactDetails("Davids 21st")
                .setContactDetails("Davids 21st")
                .build();
        // assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void d_delete() {
        repository.delete(userContact.getContactTypeId());
        assertNotNull(repository);
    }

    @Test
    void p_getAll() {
        System.out.println("Show all :");
        System.out.println(repository.getAll());

    }
}
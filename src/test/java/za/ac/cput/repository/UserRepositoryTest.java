/*  UserRepositoryTest.java
    Class to test the user repository
    Author: Wilbur Deano Smith (220003033)
    Date:  10 April 2022
*/
package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;
@TestMethodOrder(MethodOrderer.MethodName.class)

class UserRepositoryTest
{
    private static UserRepository repository = UserRepository.getRepository();
    private static User user = UserFactory.createUser("220003033", "Wilbur", "Smith");

    @Test
    void a_create()
    {
        User created = repository.create(user);
        assertEquals(user.getUserID(),created.getUserID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read()
    {
        User read = repository.read(user.getUserID());
        assertNotNull(read);
        System.out.println("Read :"+ read);
    }

    @Test
    void c_update()
    {
        User updated = new User.Builder().copy(user).setUserID("5841478")
                .setUserFirstName("Brad")
                .setUserLastName("Binder")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void e_delete()
    {
        boolean success = repository.delete(user.getUserID());
        assertTrue(success);
        System.out.println("Delete :"  + success);
    }

    @Test
    void d_getAll()
    {
        System.out.println("Show all :");
        System.out.println(repository.getAll());
    }
}
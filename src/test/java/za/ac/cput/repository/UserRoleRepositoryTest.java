/*  UserRoleRepositoryTest.java
    Class to test the userRole repository
    Author: Wilbur Deano Smith (220003033)
    Date:  10 April 2022
*/
package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import za.ac.cput.entity.UserRole;
import za.ac.cput.factory.UserRoleFactory;
@TestMethodOrder(MethodOrderer.MethodName.class)

class UserRoleRepositoryTest
{
    private static UserRoleRepository repository = UserRoleRepository.getRepository();
    private static UserRole userRole = UserRoleFactory.createUserRole("220003033", "5879");

    @Test
    void a_create()
    {
        UserRole created = repository.create(userRole);
        assertEquals(userRole.getUserID(),created.getUserID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read()
    {
        UserRole read = repository.read(userRole.getUserID());
        assertNotNull(read);
        System.out.println("Read :"+ read);
    }

    @Test
    void c_update()
    {
        UserRole updated = new UserRole.Builder().copy(userRole).setUserID("223335487")
                        .setRoleID("9814")
                        .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void e_delete()
    {
        boolean success = repository.delete(userRole.getUserID());
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
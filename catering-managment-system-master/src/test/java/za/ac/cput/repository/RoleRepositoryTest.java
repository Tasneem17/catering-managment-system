/*  RoleRepositoryTest.java
    Class to test the role repository
    Author: Wilbur Deano Smith (220003033)
    Date:  10 April 2022
*/
package za.ac.cput.repository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import za.ac.cput.entity.Role;
import za.ac.cput.factory.RoleFactory;
@TestMethodOrder(MethodOrderer.MethodName.class)

class RoleRepositoryTest
{

    private static RoleRepository repository = RoleRepository.getRepository();
    private static Role role = RoleFactory.createRole("5487", "Waiter", "Serves food");

    @Test
    void a_create()
    {
        Role created = repository.create(role);
        assertEquals(role.getRoleID(),created.getRoleID());
        System.out.println("Create: " + created);
    }

    @Test
    void b_read()
    {
        Role read = repository.read(role.getRoleID());
        assertNotNull(read);
        System.out.println("Read :"+ read);
    }

    @Test
    void c_update()
    {
        Role updated = new Role.Builder().copy(role).setRoleID("9651")
                        .setRoleName("Barman")
                        .setRoleDescription("Serves and makes drinks")
                        .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: "+ updated);
    }

    @Test
    void e_delete()
    {
        boolean success = repository.delete(role.getRoleID());
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
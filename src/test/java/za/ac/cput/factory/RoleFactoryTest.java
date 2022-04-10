/*  UserRoleFactoryTest.java
    Testing the entity UserRoleFactory
    Author: Wilbur Deano Smith (220003033)
    Date:  10 April 2022
*/
package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Role;

class RoleFactoryTest
{
    @Test
    public void createRole()
    {
        Role role = RoleFactory.createRole("5487", "Waiter", "Serves guests");
        assertNotNull(role);
        System.out.println(role);
    }
}
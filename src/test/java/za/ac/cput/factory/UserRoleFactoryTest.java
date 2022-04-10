/*  UserRoleFactoryTest.java
    Testing the entity UserRoleFactory
    Author: Wilbur Deano Smith (220003033)
    Date:  10 April 2022
*/
package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.UserRole;

class UserRoleFactoryTest
{
    @Test
    public void createUserRole()
    {
        UserRole userRole = UserRoleFactory.createUserRole("220003033", "5487");
        assertNotNull(userRole);
        System.out.println(userRole);
    }
}
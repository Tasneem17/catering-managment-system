/*  UserFactoryTest.java
    Testing the entity UserFactory
    Author: Wilbur Deano Smith (220003033)
    Date:  10 April 2022
*/
package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.User;

class UserFactoryTest
{
    @Test
    public void createUser()
    {
        User user  = UserFactory.createUser("220003033", "Wilbur", "Smith");
        assertNotNull(user);
        System.out.println(user);
        System.out.println(user.getUserID());
    }
}
/*  User.java
    Creating a factory for the entity User
    Author: Wilbur Deano Smith (220003033)
    Date: 7 April 2022
*/
package za.ac.cput.factory;

import za.ac.cput.entity.User;

public class UserFactory
{
    public static User createUser(int id, String firstName, String lastName)
    {
        return new User.Builder().setUserID(id)
                .setUserFirstName(firstName)
                .setUserLastName(lastName)
                .build();
    }

}

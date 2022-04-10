/*  UserFactory.java
    Creating a factory for the entity User
    Author: Wilbur Deano Smith (220003033)
    Date: 7 April 2022
*/
package za.ac.cput.factory;

import za.ac.cput.entity.User;
import za.ac.cput.util.Helper;

public class UserFactory
{
    public static User createUser(String id, String firstName, String lastName)
    {
        if (Helper.isNullorEmpty(id)|| Helper.isNullorEmpty(firstName)|| Helper.isNullorEmpty(lastName))
            return null;

        if (id.equals("")||id == null)
            return null;
        if (firstName.equals("")||firstName== null)
            return null;
        if(lastName.equals("")|| lastName== null)
            return null;

        return new User.Builder().setUserID(id)
                .setUserFirstName(firstName)
                .setUserLastName(lastName)
                .build();
    }

}

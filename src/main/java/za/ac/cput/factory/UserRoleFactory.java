/*  UserRoleFactory.java
    Creating a factory for the entity UserRole
    Author: Wilbur Deano Smith (220003033)
    Date: 10 April 2022
*/
package za.ac.cput.factory;

import za.ac.cput.util.Helper;
import za.ac.cput.entity.UserRole;

public class UserRoleFactory
{
    public static UserRole createUserRole(String userID, String roleID)
    {
        if (Helper.isNullorEmpty(userID)|| Helper.isNullorEmpty(roleID))
            return null;

        if (userID.equals("")||userID == null)
            return null;
        if (roleID.equals("")||roleID== null)
            return null;

        return new UserRole.Builder().setUserID(userID)
                .setRoleID(roleID)
                .build();

    }

    public static UserRole.UserRoleId buildId(UserRole userRole)
    {
        return new UserRole.UserRoleId(userRole.getUserID(),
                userRole.getRoleID());
    }
}

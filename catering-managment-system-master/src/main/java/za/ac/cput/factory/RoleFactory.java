/*  RoleFactory.java
    Creating a factory for the entity Role
    Author: Wilbur Deano Smith (220003033)
    Date: 10 April 2022
*/
package za.ac.cput.factory;

import za.ac.cput.util.Helper;
import za.ac.cput.entity.Role;

public class RoleFactory
{
    public static Role createRole(String id, String name, String description)
    {
        if (Helper.isNullorEmpty(id)|| Helper.isNullorEmpty(name)|| Helper.isNullorEmpty(description))
            return null;

        if (id.equals("")||id == null)
            return null;
        if (name.equals("")||name== null)
            return null;
        if(description.equals("")|| description== null)
            return null;

        return new Role.Builder().setRoleID(id)
                .setRoleName(name)
                .setRoleDescription(description)
                .build();
    }
}

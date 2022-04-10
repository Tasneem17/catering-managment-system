/*  UserRoleRepository.java
    Class to manage the roles of users
    Author: Wilbur Deano Smith (220003033)
    Date:  10 April 2022
*/
package za.ac.cput.repository;

import za.ac.cput.entity.UserRole;
import java.util.HashSet;
import java.util.Set;

public class UserRoleRepository implements IUserRole
{
    private static UserRoleRepository repository = null;
    private Set<UserRole> userRoleDB = null;

    private UserRoleRepository()
    {
        userRoleDB =  new HashSet<UserRole>();
    }

    public static UserRoleRepository getRepository()
    {
        if(repository == null)
        {
            repository = new UserRoleRepository();
        }
        return repository;
    }

     @Override
    public UserRole create(UserRole userRole)
    {
        boolean success = userRoleDB.add(userRole);
        if (!success)
            return null;
        return userRole;
    }

    @Override
    public UserRole read(String userID)
    {
        for (UserRole userRole :userRoleDB)
        {
            if (userRole.getUserID().equals(userID))
                return userRole;
        }
        return null;
    }

    @Override
    public UserRole update(UserRole userRole)
    {
        UserRole oldUserRole = read(userRole.getUserID());
        if(userRole != null)
        {
            userRoleDB.remove(oldUserRole);
            userRoleDB.add(userRole);
            return userRole;
        }
        return null;
    }

    @Override
    public boolean delete(String userID)
    {
        UserRole userRoleToDelete = read (userID);
        if (userRoleToDelete == null)
            return false;
        userRoleDB.remove(userRoleToDelete);
        return true;
    }

     @Override
    public Set<UserRole> getAll()
    {
        return  userRoleDB;
    }
}

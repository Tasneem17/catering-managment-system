/*  UserRepository.java
    Class to manage roles
    Author: Wilbur Deano Smith (220003033)
    Date:  10 April 2022
*/
package za.ac.cput.repository;

import za.ac.cput.entity.Role;
import java.util.HashSet;
import java.util.Set;

public class RoleRepository implements IRole
{
    private static RoleRepository repository = null;
    private Set<Role> roleDB = null;

    private RoleRepository()
    {
        roleDB =  new HashSet<Role>();
    }

    public static RoleRepository getRepository()
    {
        if(repository == null)
        {
            repository = new RoleRepository();
        }
        return repository;
    }

    @Override
    public Role create(Role role)
    {
        boolean success = roleDB.add(role);
        if (!success)
            return null;
        return role;
    }

    @Override
    public Role read(String roleID)
    {
        for (Role role :roleDB)
        {
            if (role.getRoleID().equals(roleID))
                return role;
        }
        return null;
    }


    @Override
    public Role update(Role role)
    {
        Role oldRole = read(role.getRoleID());
        if(role != null)
        {
            roleDB.remove(oldRole);
            roleDB.add(role);
            return role;
        }
        return null;
    }


    @Override
    public boolean delete(String roleID)
    {
        Role roleToDelete = read(roleID);
        if (roleToDelete == null)
            return false;
        roleDB.remove(roleToDelete);
        return true;
    }

    @Override
    public Set<Role> getAll()
    {
        return  roleDB;
    }

}

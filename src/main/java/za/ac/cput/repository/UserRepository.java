/*  UserRepository.java
    Class to manage users
    Author: Wilbur Deano Smith (220003033)
    Date:  10 April 2022
*/
package za.ac.cput.repository;

import za.ac.cput.entity.User;
import java.util.HashSet;
import java.util.Set;

public class UserRepository implements IUser
{
    private static UserRepository repository = null;
    private Set<User> userDB = null;

    private UserRepository()
    {
        userDB =  new HashSet<User>();
    }

    public static UserRepository getRepository()
    {
        if(repository == null)
        {
            repository = new UserRepository();
        }
        return repository;
    }

    @Override
    public User create(User user)
    {
        boolean success = userDB.add(user);
        if (!success)
            return null;
        return user;
    }

    @Override
    public User read(String userID)
    {
        for (User user :userDB)
        {
            if (user.getUserID().equals(userID))
                return user;
        }
        return null;
    }

    @Override
    public User update(User user)
    {
        User oldUser = read(user.getUserID());
        if(user != null)
        {
            userDB.remove(oldUser);
            userDB.add(user);
            return user;
        }
        return null;
    }

    @Override
    public boolean delete(String userID)
    {
        User userToDelete = read (userID);
        if (userToDelete == null)
            return false;
        userDB.remove(userToDelete);
        return true;
    }

    @Override
    public Set<User> getAll()
    {
        return  userDB;
    }
}

package za.ac.cput.repository;

import za.ac.cput.entity.User;

import java.util.HashSet;
import java.util.Set;

public class UserRepository
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

    public void create(){}

    public void read(){}

    public void update(){}

    public void delete(){}

    public void getAll(){}
}

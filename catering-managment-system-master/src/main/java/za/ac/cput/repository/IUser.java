/*  IUser.java
    Interface for the user repository
    Author: Wilbur Deano Smith (220003033)
    Date:  10 April 2022
*/
package za.ac.cput.repository;

import za.ac.cput.entity.User;
import java.util.Set;

public interface IUser extends IRepository<User,String>
{
    public Set<User> getAll();
}

/*  IUserRole.java
    Interface for the userRole repository
    Author: Wilbur Deano Smith (220003033)
    Date:  10 April 2022
*/
package za.ac.cput.repository;

import za.ac.cput.entity.UserRole;
import java.util.Set;

public interface IUserRole extends IRepository<UserRole,String>
{
    public Set<UserRole> getAll();
}

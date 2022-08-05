/*  IRole.java
    Interface for the role repository
    Author: Wilbur Deano Smith (220003033)
    Date:  10 April 2022
*/
package za.ac.cput.repository;

import za.ac.cput.entity.Role;
import java.util.Set;

public interface IRole extends IRepository<Role,String>
{
    public Set<Role> getAll();
}

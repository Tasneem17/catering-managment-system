/*  RoleRepository.java
    Interface for the role repository
    Author: Wilbur Deano Smith (220003033)
    Date:  5 August 2022
*/
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Role;
import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,String>
{
}

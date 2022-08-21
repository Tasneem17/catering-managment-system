/*  UserRoleRepository.java
    Interface for the userRole repository
    Author: Wilbur Deano Smith (220003033)
    Date:  5 August 2022
*/
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.UserRole;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRole.UserRoleId>
{
    UserRole findUserRoleByUserID(String userID);
    void deleteUserRoleByUserID(String userID);

}

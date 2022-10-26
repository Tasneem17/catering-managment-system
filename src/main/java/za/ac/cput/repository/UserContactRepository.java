/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.UserContact;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserContactRepository extends JpaRepository<UserContact, String> {

//    List<UserContact> findAll();
//
//    UserContact findByUserId(String userContactID);
//
//    void deleteUserContactByUserID(String userContactID);
//
//    Optional<UserContact> findByFirstName(String firstname);
}
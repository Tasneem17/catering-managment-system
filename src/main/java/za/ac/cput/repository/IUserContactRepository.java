/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.repository;

import za.ac.cput.entity.UserContact;

import java.util.Set;

public interface IUserContactRepository extends IRepository<UserContact, String> {


    public Set<UserContact> getAll();
}

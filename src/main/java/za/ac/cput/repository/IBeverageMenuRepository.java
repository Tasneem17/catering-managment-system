/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Interface:BeverageMenuRepository
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.BeverageMenu;

import java.util.Optional;
import java.util.Set;
@Repository
public interface IBeverageMenuRepository extends JpaRepository<BeverageMenu,String> {


}



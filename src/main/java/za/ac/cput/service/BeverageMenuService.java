/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *service:IBeverageMenuService
 */
package za.ac.cput.service;

import za.ac.cput.entity.BeverageMenu;

import java.util.List;
import java.util.Optional;

public interface BeverageMenuService {
    BeverageMenu save(BeverageMenu beverageMenu);

    List<BeverageMenu> findAllBeverageName(String beverageName);

    boolean deleteBybeverageName(String beverageName);

    Optional<BeverageMenu> read(String beverageName);

    List<BeverageMenu> findAll();
}

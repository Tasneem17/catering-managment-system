/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *service:IBeverageMenuService
 */
package za.ac.cput.service;

import za.ac.cput.entity.BeverageMenu;

import java.util.List;

public interface BeverageMenuService extends IService<BeverageMenu,String>{
    List<BeverageMenu> findAllBeverageName(String beverageName);

    void deleteBybeverageName(String beverageName);

    List<BeverageMenu> findAll();
}

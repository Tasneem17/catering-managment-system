/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Interface:BeverageMenu
 */package za.ac.cput.repository;

import za.ac.cput.entity.BeverageMenu;

import java.util.Set;

public interface IBeverageMenu extends IRepository<BeverageMenu,String> {

        //create,read,update ,delete
        public Set<BeverageMenu> getAll();

    }



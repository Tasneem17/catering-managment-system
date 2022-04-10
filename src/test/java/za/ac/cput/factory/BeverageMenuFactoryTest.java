/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Test: Beverage Menu
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.BeverageMenu;

import static org.junit.jupiter.api.Assertions.assertNotNull;


class BeverageMenuFactoryTest {
    @Test
    void createBeverageMenu() {
        BeverageMenu beverageMenu = BeverageMenuFactory.createBeverageMenu("Tropical Splash", "R50", "Apples,pear and orange", "5", "50");
        assertNotNull(beverageMenu);
        System.out.println(beverageMenu);


     }


}
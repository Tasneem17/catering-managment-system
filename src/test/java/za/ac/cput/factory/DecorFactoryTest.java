/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Test:DecorFactory
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Decor;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DecorFactoryTest {
    @Test
    void createDecor(){

       Decor decor = DecorFactory.createDecor("Table Cloth","Medium","5","R500");
        assertNotNull(decor);
        System.out.println(decor);
    }


}

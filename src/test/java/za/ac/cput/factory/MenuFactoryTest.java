/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Menu;


import static org.junit.jupiter.api.Assertions.*;

class MenuFactoryTest {
    @Test
    public void test1(){
        Menu menu  =MenuFactory.createMenu("787","8",520.50);
        System.out.println(menu.toString());
    }

}
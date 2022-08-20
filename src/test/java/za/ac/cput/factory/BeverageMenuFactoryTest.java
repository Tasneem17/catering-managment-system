/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Test: Beverage Menu
 */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.BeverageMenu;
import za.ac.cput.entity.BeverageMenu;

import static org.junit.jupiter.api.Assertions.*;


class BeverageMenuFactoryTest {
   @Test
public void buildWithSuccess() {

    BeverageMenu beverageMenu = BeverageMenuFactory
            .build("Tropical splash","","","","");
    System.out.println(beverageMenu);
    assertNotNull(beverageMenu);
}

    @Test
    public void buildWithError() {

        Exception  exception = assertThrows(IllegalArgumentException.class,() ->
                BeverageMenuFactory
                        .build("null","","","",""));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame( "beverage name is required!",exceptionMessage );
    }

}

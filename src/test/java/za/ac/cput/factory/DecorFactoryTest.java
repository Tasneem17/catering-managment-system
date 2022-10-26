/*
 *Author:Tasneem Jacobs 215030389
 *Applications Development ADP3
 *Assignment 1
 *Test:DecorFactory
 */
package za.ac.cput.factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Decor;

import static org.junit.jupiter.api.Assertions.*;

class DecorFactoryTest {
    @Test
    public void buildWithSuccess() {

        Decor decor = DecorFactory
                .createDecor("Table Cloth","","","");
        System.out.println(decor);
        assertNotNull(decor);
    }

    @Test
    public void buildWithError() {

        Exception  exception = assertThrows(IllegalArgumentException.class,() ->
                DecorFactory
                        .createDecor("null","","",""));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame( "decor type required!",exceptionMessage );
    }

}


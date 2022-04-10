/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.UserContact;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserContactFactoryTest {
    @Test

    void createUserContact(){
        UserContact userContact = UserContactFactory.createUserContact("9652359357753","Cell Phone","0725759865");
        assertNotNull(userContact);
        System.out.println(userContact);
    }

}






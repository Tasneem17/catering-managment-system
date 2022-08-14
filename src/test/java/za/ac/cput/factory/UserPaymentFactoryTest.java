package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.UserPayment;

import static org.junit.jupiter.api.Assertions.*;

class UserPaymentFactoryTest {
    @Test
    public void test() {
        UserPayment userPayment = UserPaymentFactory.buildUserPayment("001","Cash","R3000" );
        assertNotNull(userPayment);
        System.out.println(userPayment);
    }
}
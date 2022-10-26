package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EventStatus;
import za.ac.cput.entity.UserPayment;

import static org.junit.jupiter.api.Assertions.*;

class UserPaymentFactoryTest {
    @Test
    public void buildWithSuccess() {

        UserPayment userPayment = UserPaymentFactory
                .build("001","active","$490");
        System.out.println(userPayment);
        assertNotNull(userPayment);
    }

    @Test
    public void buildWithError() {

        Exception  exception = assertThrows(IllegalArgumentException.class,() ->
                UserPaymentFactory
                        .build("null","",""));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame( "ID is required!",exceptionMessage );
    }
}
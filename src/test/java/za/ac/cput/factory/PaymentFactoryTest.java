package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.entity.Payment;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    @Test
    public void buildWithSuccess() {

        Payment payment = PaymentFactory
                .build("001","active","");
        System.out.println(payment);
        assertNotNull(payment);
    }

    @Test
    public void buildWithError() {

        Exception  exception = assertThrows(IllegalArgumentException.class,() ->
                PaymentFactory
                        .build("null","",""));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame( " payment ID is required!",exceptionMessage );
    }
}
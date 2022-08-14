package za.ac.cput.factory;

import za.ac.cput.entity.Appointment;
import za.ac.cput.entity.Payment;
import za.ac.cput.util.Helper;

public class PaymentFactory {
    public static Payment build(String payment_id, String payment_name, String payment_description){

        if (Helper.isNullorEmpty(payment_id)|| Helper.isNullorEmpty(payment_name)|| Helper.isNullorEmpty( payment_description))
            return null;

        if (payment_id.equals("payment_id")||payment_id == null)
            return null;
        if (payment_name.equals("")||payment_name== null)
            return null;
        if(payment_description.equals("")|| payment_description== null)
            return null;

        return new Payment.Builder().setPayment_id(payment_id)
                .setPayment_name(payment_name)
                .setPayment_description(payment_description)
                .build();
    }
}

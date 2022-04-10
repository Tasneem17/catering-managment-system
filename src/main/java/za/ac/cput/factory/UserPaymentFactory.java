package za.ac.cput.factory;


import za.ac.cput.entity.UserPayment;
import za.ac.cput.util.Helper;

public class UserPaymentFactory {
    public static UserPayment createUserPayment(String id, String typeID, String amount) {

        if (Helper.isNullorEmpty(id) || Helper.isNullorEmpty(typeID) || Helper.isNullorEmpty(typeID))
            return null;

        if (id.equals("id") || id == null)
            return null;
        if (typeID.equals("") || typeID == null)
            return null;
        if (amount.equals("") || amount == null)
            return null;

        return new UserPayment.Builder().setId(id)
                .setTypeID(typeID)
                .setAmount(amount)
                .build();
    }
}

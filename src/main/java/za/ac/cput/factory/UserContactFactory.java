/*
 *Author:Brady Sheldon 219053715
 *Applications Development ADP3
 *Assignment 1
 */
package za.ac.cput.factory;

import za.ac.cput.entity.UserContact;
import za.ac.cput.util.Helper;

public class UserContactFactory {
    public static UserContact createUserContact(String User_id,String Contact_type_id,String Contact_details){
        if (Helper.isNullorEmpty(User_id)|| Helper.isNullorEmpty(Contact_type_id)|| Helper.isNullorEmpty(Contact_details))
            return null;

        if (User_id.equals("")||User_id == null)
            return null;
        if (Contact_type_id.equals("")||Contact_type_id== null)
            return null;
        if(Contact_details.equals("")|| Contact_details== null)
            return null;

        return new UserContact.Builder().setUserId(User_id)
                .setContactTypeId(Contact_type_id)
                .setContactDetails(Contact_details)
                .build();

    }
}

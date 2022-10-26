/* ContactTypeFactory.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.factory;

import za.ac.cput.entity.ContactType;
import za.ac.cput.util.Helper;

public class ContactTypeFactory {

    public static ContactType build(String contactTypeId, String contactTypeName, String contactTypeDescription) {

        if (Helper.isNullorEmpty(contactTypeId)|| Helper.isNullorEmpty(contactTypeName)|| Helper.isNullorEmpty(contactTypeDescription))
            return null;

        if (contactTypeId.equals("")||contactTypeId == null)
            return null;
        if (contactTypeName.equals("")||contactTypeName== null)
            return null;
        if(contactTypeDescription.equals("")|| contactTypeDescription== null)
            return null;

        return new ContactType.Builder().setContactTypeId(contactTypeId)
                .setContactTypeName(contactTypeName)
                .setContactTypeDescription(contactTypeDescription)
                .build();
    }
}

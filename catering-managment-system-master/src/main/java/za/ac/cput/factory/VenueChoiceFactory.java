/* VenueChoiceFactory.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.factory;

import za.ac.cput.entity.VenueChoice;
import za.ac.cput.util.Helper;

public class VenueChoiceFactory {
    public static VenueChoice createVenueChoice(String venueId, String venueType) {

        if (Helper.isNullorEmpty(venueId)|| Helper.isNullorEmpty(venueType))
            return null;

        if (venueId.equals("")||venueId == null)
            return null;
        if (venueType.equals("")||venueType== null)
            return null;

        return new VenueChoice.Builder().setVenueId(venueId)
                .setVenueType(venueType)
                .build();
    }
}

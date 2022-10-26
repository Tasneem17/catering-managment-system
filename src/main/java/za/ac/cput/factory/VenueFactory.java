/* VenueFactory.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.factory;

import za.ac.cput.entity.Venue;
import za.ac.cput.util.Helper;

public class VenueFactory {
    public static Venue build(String venueId, String venueName, double venuePrice, String venueDescription) {

        if (Helper.isNullorEmpty(venueName)|| Helper.isNullorEmpty(venueDescription))
            return null;

        if (venueName.equals("")||venueName == null)
            return null;

        if(venueDescription.equals("")|| venueDescription== null)
            return null;

        return new Venue.Builder().setVenueName(venueName)
                .setVenuePrice(venuePrice)
                .setVenueDescription(venueDescription)
                .build();
    }
}

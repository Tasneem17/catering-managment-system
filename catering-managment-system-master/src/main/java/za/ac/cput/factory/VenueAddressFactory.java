/* VenueAddressFactory.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.factory;

import za.ac.cput.entity.VenueAddress;
import za.ac.cput.util.Helper;

public class VenueAddressFactory {
    public static VenueAddress createVenueAddress(String venueAddressArea, String venueAddressCity, String venueAddressStreet) {

        if (Helper.isNullorEmpty(venueAddressArea)|| Helper.isNullorEmpty(venueAddressCity)|| Helper.isNullorEmpty(venueAddressStreet))
            return null;

        if (venueAddressArea.equals("")||venueAddressArea == null)
            return null;
        if (venueAddressCity.equals("")||venueAddressCity== null)
            return null;
        if(venueAddressStreet.equals("")|| venueAddressStreet== null)
            return null;

        return new VenueAddress.Builder().setVenueAddressArea(venueAddressArea)
                .setVenueAddressCity(venueAddressCity)
                .setVenueAddressStreet(venueAddressStreet)
                .build();
    }
}
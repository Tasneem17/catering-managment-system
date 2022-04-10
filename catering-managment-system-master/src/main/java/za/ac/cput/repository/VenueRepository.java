/* VenueRepository.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.repository;

import za.ac.cput.entity.ContactType;
import za.ac.cput.entity.Venue;
import java.util.HashSet;
import java.util.Set;

public class VenueRepository {
    private static VenueRepository repository = null;
    public Set<Venue> venueDB = null;

    private VenueRepository(){
        venueDB  = new HashSet<Venue>();
    }

    public static  VenueRepository getRepository(){
        if (repository == null){
            repository = new VenueRepository();
        }
        return repository;
    }

    public Venue create(Venue venue) {
        boolean success = venueDB.add(venue);
        if (!success)
            return null;
        return venue;
    }


    public Venue read(String venueId) {
        for (Venue v :venueDB) {
            if (v.getVenueId().equals(venueId))
                return v;
        }
        return null;
    }

    public Venue update(Venue venue){
        Venue oldVenue = read(venue.getVenueId());
        if(oldVenue != null){
            venueDB.remove(oldVenue);
            venueDB.add(venue);
            return venue;
        }
        return null;
    }


    public boolean delete(String venueId) {
        Venue venueTODelete = read (venueId);
        if (venueTODelete == null)
            return false;
        venueDB.remove(venueTODelete);
        return true;
    }


    public Set< Venue > getAll() {
        return  venueDB;
    }
}

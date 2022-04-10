/* ContactTypeRepository.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.repository;

import za.ac.cput.entity.VenueChoice;
import java.util.HashSet;
import java.util.Set;

public class VenueChoiceRepository {
    private static VenueChoiceRepository repository = null;
    private Set<VenueChoice> venueChoiceDB = null;

    private VenueChoiceRepository(){
        venueChoiceDB  = new HashSet<VenueChoice>();
    }

    public static  VenueChoiceRepository getRepository(){
        if (repository == null){
            repository = new VenueChoiceRepository();
        }
        return repository;
    }

    public VenueChoice create(VenueChoice venueChoice) {
        boolean success = venueChoiceDB.add(venueChoice);
        if (!success)
            return null;
        return venueChoice;
    }

    public VenueChoice read(String VenueId) {
        for (VenueChoice vc :venueChoiceDB) {
            if (vc.getVenueId().equals(VenueId))
                return vc;
        }
        return null;
    }

    public VenueChoice update(VenueChoice venueChoice) {
        VenueChoice oldVenueChoice = read(venueChoice.getVenueId());
        if (oldVenueChoice != null) {
            venueChoiceDB.remove(oldVenueChoice);
            venueChoiceDB.add(venueChoice);
            return venueChoice;
        }
        return null;
    }

    public boolean delete(String venueId) {
        VenueChoice   venueChoiceTODelete = read (venueId);
        if (venueChoiceTODelete == null)
            return false;
        venueChoiceDB.remove(venueChoiceTODelete);
        return true;
    }

    public Set< VenueChoice > getAll() {
        return  venueChoiceDB;
    }
}

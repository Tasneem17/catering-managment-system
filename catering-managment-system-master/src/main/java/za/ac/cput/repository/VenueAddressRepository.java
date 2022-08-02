/* VenueAddressRepositoryTest.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.repository;

import za.ac.cput.entity.VenueAddress;
import za.ac.cput.entity.VenueChoice;

import java.util.HashSet;
import java.util.Set;


public class VenueAddressRepository {
    private static VenueAddressRepository repository = null;
    private Set<VenueAddress> venueAddressDB = null;

    private VenueAddressRepository(){
        venueAddressDB  = new HashSet<VenueAddress>();
    }

    public static  VenueAddressRepository getRepository(){
        if (repository == null){
            repository = new VenueAddressRepository();
        }
        return repository;
    }

    public VenueAddress create(VenueAddress venueAddress) {
        boolean success = venueAddressDB.add(venueAddress);
        if (!success)
            return null;
        return venueAddress;
    }

    public VenueAddress read(String VenueAddressArea) {
        for (VenueAddress va :venueAddressDB) {
            if (va.getVenueAddressArea().equals(VenueAddressArea))
                return va;
        }
        return null;
    }

    public VenueAddress update(VenueAddress venueAddress) {
        VenueAddress oldvenueAddress = read(venueAddress.getVenueAddressArea());
        if (oldvenueAddress != null) {
            venueAddressDB.remove(oldvenueAddress);
            venueAddressDB.add(venueAddress);
            return venueAddress;
        }
        return null;
    }

    public boolean delete(String venueAddressArea) {
        VenueAddress   venueAddressTODelete = read (venueAddressArea);
        if (venueAddressTODelete == null)
            return false;
        venueAddressDB.remove(venueAddressTODelete);
        return true;
    }

    public Set< VenueAddress > getAll() {
        return  venueAddressDB;
    }
}
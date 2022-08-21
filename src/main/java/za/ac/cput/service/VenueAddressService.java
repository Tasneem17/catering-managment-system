/* VenueAddressService.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service;

import za.ac.cput.entity.VenueAddress;
import java.util.Set;

public interface VenueAddressService extends IService<VenueAddress, String>{
    public Set<VenueAddress> getAll();

    void deleteById(String id);
}

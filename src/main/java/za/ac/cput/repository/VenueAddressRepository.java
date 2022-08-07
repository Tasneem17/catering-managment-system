/* VenueAddressRepository.java
 Author: Chad Siegelaar (218340982)
 Date: 07 April 2022
*/

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.VenueAddress;
import java.util.Set;

@Repository
public interface VenueAddressRepository extends JpaRepository<VenueAddress, String> {
    public Set<VenueAddress> getAll();
}

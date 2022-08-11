/* VenueServiceImpl.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Venue;
import za.ac.cput.repository.VenueRepository;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VenueServiceImpl implements VenueService {
    private VenueRepository repository;

    @Autowired
    VenueServiceImpl(VenueRepository repository) {
        this.repository = repository;}

    @Override
    public Venue save(Venue venue) {
        return this.repository.save(venue);}

    @Override
    public Venue read(String id) {
        return this.repository.findById(id).orElse(null);}

    @Override
    public boolean delete(String id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Set<Venue> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}


/* VenueServiceImpl.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Venue;
import za.ac.cput.repository.VenueRepository;
import za.ac.cput.service.VenueService;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public abstract class VenueServiceImpl implements VenueService {
    private VenueRepository repository;

    @Autowired
    VenueServiceImpl(VenueRepository repository) {
        this.repository = repository;}

    public Venue save(Venue venue) {
        return this.repository.save(venue);}

    public Optional<Venue> read(String id) {
        return Optional.ofNullable(this.repository.findById(id).orElse(null));}

    public boolean deleteById(String venue){
        this.repository.deleteById(venue);
        return false;
    }


    public Set<Venue> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}


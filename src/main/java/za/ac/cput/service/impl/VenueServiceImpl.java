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

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VenueServiceImpl implements VenueService {
    private VenueRepository repository;

    @Autowired
    VenueServiceImpl(VenueRepository repository) {
        this.repository = repository;}

    public Venue save(Venue venue) {
        return this.repository.save(venue);}
    @Override
    public Optional<Venue> read(String id) {
        return Optional.ofNullable(this.repository.findById(id).orElse(null));}
    @Override
    public void deleteById(String venueId){
        this.repository.deleteById(venueId);
    }

    @Override
    public List<Venue> findAll() {
        return this.repository.findAll();
    }
}


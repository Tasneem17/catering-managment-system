/* VenueAddressServiceImpl.java
 Author: Chad Siegelaar (218340982)
 Date: 11 August 2022
*/

package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.VenueAddress;
import za.ac.cput.repository.VenueAddressRepository;
import za.ac.cput.service.VenueAddressService;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public  class VenueAddressServiceImpl implements VenueAddressService {
    private VenueAddressRepository repository;

    @Autowired
    VenueAddressServiceImpl(VenueAddressRepository repository) {
        this.repository = repository;}


    public VenueAddress save(VenueAddress venueAddress) {
        return this.repository.save(venueAddress);}


    public Optional<VenueAddress> read(String id) {
        return Optional.ofNullable(this.repository.findById(id).orElse(null));}


    public boolean deleteById(String venueAddress){
        this.repository.deleteById(venueAddress);
        return false;
    }

    @Override
    public Set<VenueAddress> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}

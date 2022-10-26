/* VenueAddressController.java
 Author: Chad Siegelaar (218340982)
 Date: 18 August 2022
*/

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.VenueAddress;
import za.ac.cput.service.impl.VenueAddressServiceImpl;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("catering-db/venueAddress")
public class VenueAddressController {
    private VenueAddressServiceImpl venueAddressService;

    @Autowired
    VenueAddressController(VenueAddressServiceImpl venueAddressService) {
        this.venueAddressService = venueAddressService;
    }

    @PostMapping("save")
    public ResponseEntity<VenueAddress> save(@Valid @RequestBody VenueAddress venueAddress) {
        return ResponseEntity.ok(this.venueAddressService.save(venueAddress));
    }

    @GetMapping("read/{type}")
    public ResponseEntity<VenueAddress> read(@PathVariable String venueAddressId) {
        VenueAddress read = this.venueAddressService.read(venueAddressId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "VenueAddress not found"));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.venueAddressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<VenueAddress>> findAll() {
        List<VenueAddress> venueAddresss = (List<VenueAddress>) this.venueAddressService.findAll();
        return ResponseEntity.ok(venueAddresss);
    }
}
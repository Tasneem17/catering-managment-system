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
@RequestMapping("/venueAddress")
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
    public ResponseEntity<VenueAddress> read(@PathVariable String id) {
        VenueAddress read = this.venueAddressService.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Address not found"));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{type}")
    public ResponseEntity<Void> deletebyId(@PathVariable String id) {
        this.venueAddressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<VenueAddress>> getAll() {
        List<VenueAddress> venueAddresses = (List<VenueAddress>) this.venueAddressService.getAll();
        return ResponseEntity.ok(venueAddresses);
    }
}

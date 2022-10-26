/* VenueController.java
 Author: Chad Siegelaar (218340982)
 Date: 18 August 2022
*/

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.ContactType;
import za.ac.cput.entity.Venue;
import za.ac.cput.service.impl.VenueServiceImpl;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/venue")
public class VenueController {
    private VenueServiceImpl venueService;

    @Autowired
    VenueController(VenueServiceImpl venueService) {
        this.venueService = venueService;
    }

    @PostMapping("save")
    public ResponseEntity<Venue> save(@Valid @RequestBody Venue venue) {
        return ResponseEntity.ok(this.venueService.save(venue));
    }

    @GetMapping("read/{type}")
    public ResponseEntity<Venue> read(@PathVariable String venueId) {
        Venue read = this.venueService.read(venueId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Venue not found"));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.venueService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Venue>> findAll() {
        List<Venue> venues = (List<Venue>) this.venueService.findAll();
        return ResponseEntity.ok(venues);
    }
}
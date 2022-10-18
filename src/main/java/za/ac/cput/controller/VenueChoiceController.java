/* VenueChoiceController.java
 Author: Chad Siegelaar (218340982)
 Date: 18 August 2022
*/

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.VenueChoice;
import za.ac.cput.service.impl.VenueChoiceServiceImpl;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/venueChoice")
public class VenueChoiceController {
    private VenueChoiceServiceImpl venueChoiceService;

    @Autowired
    VenueChoiceController(VenueChoiceServiceImpl venueChoiceService) {
        this.venueChoiceService = venueChoiceService;
    }

    @PostMapping("save")
    public ResponseEntity<VenueChoice> save(@Valid @RequestBody VenueChoice venueChoice) {
        return ResponseEntity.ok(this.venueChoiceService.save(venueChoice));
    }

    @GetMapping("read/{type}")
    public ResponseEntity<VenueChoice> read(@PathVariable String venueId) {
        VenueChoice read = this.venueChoiceService.read(venueId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Address not found"));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.venueChoiceService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<VenueChoice>> getAll() {
        List<VenueChoice> venueChoices = (List<VenueChoice>) this.venueChoiceService.getAll();
        return ResponseEntity.ok(venueChoices);
    }
}

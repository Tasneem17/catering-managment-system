/* ContactTypeController.java
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
import za.ac.cput.service.impl.ContactTypeServiceImpl;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/contactType")
public class ContactTypeController {
    private ContactTypeServiceImpl contactTypeService;

    @Autowired
    ContactTypeController(ContactTypeServiceImpl contactTypeService) {
        this.contactTypeService = contactTypeService;
    }

    @PostMapping("save")
    public ResponseEntity<ContactType> save(@Valid @RequestBody ContactType contactType) {
        return ResponseEntity.ok(this.contactTypeService.save(contactType));
    }

    @GetMapping("read/{type}")
    public ResponseEntity<ContactType> read(@PathVariable String contactTypeId) {
        ContactType read = this.contactTypeService.read(contactTypeId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Address not found"));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{type}")
    public ResponseEntity<Void> deletebyId(@PathVariable String id) {
        this.contactTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<ContactType>> getAll() {
        List<ContactType> contactTypes = (List<ContactType>) this.contactTypeService.getAll();
        return ResponseEntity.ok(contactTypes);
    }
}
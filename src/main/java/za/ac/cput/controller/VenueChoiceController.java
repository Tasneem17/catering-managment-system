/* VenueChoiceController.java
 Author: Chad Siegelaar (218340982)
 Date: 18 August 2022
*/

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.service.impl.VenueChoiceServiceImpl;

@RestController
@RequestMapping("/venueChoice")
public class VenueChoiceController {
    private VenueChoiceServiceImpl venueChoiceService;

    @Autowired
    VenueChoiceController(VenueChoiceServiceImpl venueChoiceService) {
        this.venueChoiceService = venueChoiceService;
    }

}

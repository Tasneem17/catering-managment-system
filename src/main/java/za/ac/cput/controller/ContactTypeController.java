/* ContactTypeController.java
 Author: Chad Siegelaar (218340982)
 Date: 18 August 2022
*/

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.service.impl.ContactTypeServiceImpl;


@RestController
@RequestMapping("/contactType")
public class ContactTypeController {
    private ContactTypeServiceImpl contactTypeService;

    @Autowired
    ContactTypeController(ContactTypeServiceImpl contactTypeService) {
        this.contactTypeService = contactTypeService;
    }

}

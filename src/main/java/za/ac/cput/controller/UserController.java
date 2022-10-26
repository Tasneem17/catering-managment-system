/*  UserController.java
    Controller for user
    Author: Wilbur Deano Smith (220003033)
    Date: 18 August 2022
*/
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Equipment;
import za.ac.cput.entity.User;
import za.ac.cput.service.impl.UserServiceimpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceimpl userService;

    @Autowired
    public UserController(UserServiceimpl userService){

        this.userService = userService;
    }

    @PostMapping("save")
    public ResponseEntity<User> save( @Valid @RequestBody User user)
    {
       return ResponseEntity.ok(
               this.userService.save(user)
       );
    }

    @GetMapping("read/{userID}")
    public ResponseEntity<User> read(@PathVariable String userID)
    {
        User read = this.userService.read(userID)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Address not found"));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deletebyId(@PathVariable String id)
    {
        this.userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = this.userService.findAll();
        return ResponseEntity.ok(users);
    }
}
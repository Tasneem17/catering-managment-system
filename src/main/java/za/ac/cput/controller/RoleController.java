/*  RoleController.java
    Controller for role
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
import za.ac.cput.entity.Role;
import za.ac.cput.service.impl.RoleServiceimpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleServiceimpl roleService;

    @Autowired
    public RoleController(RoleServiceimpl roleService){
        this.roleService = roleService;
    }

    @PostMapping("save")
    public ResponseEntity<Role> save(@Valid @RequestBody Role role)
    {
        return ResponseEntity.ok(
                this.roleService.save(role)
        );
    }

    @GetMapping("read/{type}")
    public ResponseEntity<Role> read(@PathVariable String roleID)
    {
        Role read = this.roleService.read(roleID)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Address not found"));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{type}")
    public ResponseEntity<Void> deletebyId(@PathVariable String id)
    {
        this.roleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Role>> findAll() {
        List<Role> roles = this.roleService.findAll();
        return ResponseEntity.ok(roles);
    }
}

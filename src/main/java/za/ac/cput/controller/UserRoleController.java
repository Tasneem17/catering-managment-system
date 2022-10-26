/*  UserRoleController.java
    Controller for userRole
    Author: Wilbur Deano Smith (220003033)
    Date: 18 August 2022
*/
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Role;
import za.ac.cput.entity.UserRole;
import za.ac.cput.service.impl.RoleServiceimpl;
import za.ac.cput.service.impl.UserRoleServiceimpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user-role/")
public class UserRoleController {

    private final UserRoleServiceimpl userRoleService;

    @Autowired
    public UserRoleController(UserRoleServiceimpl userRoleService){
        this.userRoleService = userRoleService;
    }

    @PostMapping("save")
    public ResponseEntity<UserRole> save(@Valid @RequestBody UserRole userRole)
    {
        return ResponseEntity.ok(
                this.userRoleService.save(userRole)
        );
    }

    @GetMapping("read/{userID}")
    public ResponseEntity<UserRole> read(@PathVariable String userID)
    {
        UserRole read = this.userRoleService.findUserRoleByUserID(userID);
//                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
//                        "Address not found"));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        this.userRoleService.deleteUserRoleByUserID(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<UserRole>> findAll() {
        List<UserRole> userRoles = this.userRoleService.findAll();
        return ResponseEntity.ok(userRoles);
    }


}

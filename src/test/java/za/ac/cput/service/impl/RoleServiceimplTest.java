package za.ac.cput.service.impl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Role;
import za.ac.cput.factory.RoleFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class RoleServiceimplTest {

    @Autowired
    private RoleServiceimpl roleServiceimpl;
    private Role role1 = RoleFactory.createRole("58741236",
                                                     "Manager",
                                                     "Help with day to day operations");
    private Role role2 =RoleFactory.createRole("54789314",
            "Waiter",
            "Helps bring food and drinks to tables");

    @Test
    @Order(1)
    void save() {
        Role roleSaved1 = this.roleServiceimpl.save(role1);
        Role roleSaved2 = this.roleServiceimpl.save(role2);
        assertAll(
                () -> assertNotNull(roleSaved1),
                () -> assertNotNull(roleSaved2)
        );
    }

    @Test
    @Order(2)
    void read() {
        assertEquals(this.roleServiceimpl.read(role1.getRoleID()), role1.getRoleID());
    }

    @Test
    @Order(3)
    void delete() {
      this.roleServiceimpl.delete(role1);
    }
}
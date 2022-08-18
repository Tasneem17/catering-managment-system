package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.User;
import za.ac.cput.entity.UserRole;
import za.ac.cput.factory.UserRoleFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class UserRoleServiceimplTest {

    @Autowired
    private UserRoleServiceimpl userRoleServiceimpl;
    private UserRole userRole = UserRoleFactory.createUserRole("220003033",
            "58741236");
    private UserRole.UserRoleId userRoleId = UserRoleFactory.buildId(userRole);

    @Test
    @Order(1)
    void save() {
        UserRole save = this.userRoleServiceimpl.save(userRole);
        assertAll(
                () -> assertNotNull(save),
                () -> assertNotNull(save)
        );
    }

    @Test
    @Order(2)
    void read() {
        Optional<UserRole> read = this.userRoleServiceimpl.read(userRoleId);
        assertTrue(read.isPresent());
    }

    @Test
    @Order(3)
    void delete() {
        this.userRoleServiceimpl.delete(this.userRole);
    }
}
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.User;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.factory.UserRoleFactory;
import za.ac.cput.service.UserService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class UserServiceimplTest {

    @Autowired
    private UserService userService;
    private User user  = UserFactory.createUser("220003033",
            "Wilbur",
            "Smith");

    @Test
    @Order(1)
    void save() {
        User save = this.userService.save(user);
        assertAll(
                () -> assertNotNull(save),
                () -> assertNotNull(save)
        );
    }

    @Test
    @Order(2)
    void read() {
        Optional<User> read = this.userService.read(user.getUserID());
        assertSame(read, user.getUserID());
    }

    @Test
    @Order(3)
    void delete() {
        this.userService.delete(user);
    }
}
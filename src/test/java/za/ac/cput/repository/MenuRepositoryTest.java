/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Menu;
import za.ac.cput.factory.MenuFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class MenuRepositoryTest {

    private static MenuRepository repo = MenuRepository.getRepo();
    private static Menu menu = MenuFactory.createMenu("34",250);



    @Test
    void a_create() {
        Menu created  = repo.create(menu);
        assertEquals(menu.getMenu_ID(),created.getMenu_ID());
        System.out.println("Record created:"+created);
    }

    @Test
    void c_read() {
    Menu read = repo.read(menu.getMenu_ID());
    assertNotNull(read);
    System.out.println("Reading Record:"+read);
    }

    @Test
    void b_update() {
        Menu update =new Menu.Builder().copy(menu).setMenu_Items("10")
                .setMenu_Price(300).build();
        assertNotNull(repo.update(update));
        System.out.println("Record updated:"+update);

    }

    @Test
    void e_delete() {
        boolean delete =repo.delete(menu.getMenu_ID());
        assertTrue(delete);
        System.out.println("Record deleted:"+delete);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all");
        System.out.println(repo.getAll());
    }
}
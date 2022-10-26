//package za.ac.cput.service.impl;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import za.ac.cput.entity.Menu;
//import za.ac.cput.factory.MenuFactory;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class MenuServiceImplTest {
//
//    @Autowired
//    private MenuServiceImpl menuService;
//    private static Menu menu = MenuFactory.createMenu("34",45);
//    private static Menu menu2 = MenuFactory.createMenu("12",76);
//
//
//    @Test
//    @Order(1)
//    void save() {
//        System.out.printf("Saved");
//        Menu menu_created =  menuService.save(menu);
//        assertNotNull(menu_created);
//        System.out.printf(String.valueOf(menu_created));
//
//        System.out.printf("Saved");
//        Menu menu_created2 =  this.menuService.save(menu2);
//        assertNotNull(menu_created2);
//        System.out.printf(String.valueOf(menu_created2));
//
//    }
//
//    @Test
//    @Order(2)
//    void read() {
//     Optional<Menu> read = this.menuService.read(menu.getMenu_ID());
//     assertEquals(read.get(),menu.getMenu_ID());
//        System.out.printf("Read " + read);
//
//        Optional<Menu> read2 = this.menuService.read(menu2.getMenu_ID());
//        assertEquals(read.get(),menu2.getMenu_ID());
//        System.out.printf("Read " + read2);
//    }
//
//    @Test
//    @Order(5)
//    void delete() {
//        boolean deleted = this.menuService.delete(this.menu);
//        assertTrue(deleted);
//        System.out.println("Deleted:" + deleted);
//
//        boolean deleted2 = this.menuService.delete(this.menu2);
//        assertTrue(deleted2);
//        System.out.println("Deleted:" + deleted2);
//    }
//
//    @Test
//    @Order(4)
//    void deletebyid() {
//        boolean deleted = this.menuService.deletebyid(menu.getMenu_ID());
//        assertTrue(deleted);
//        System.out.println("Deletedbyid:" + deleted);
//
//        boolean deleted2 = this.menuService.deletebyid(menu2.getMenu_ID());
//        assertTrue(deleted2);
//        System.out.println("Deletedbyid:" + deleted2);
//    }
//
//    @Test
//    @Order(3)
//    void findall() {
//        this.menuService.findall(menu);
//        System.out.println(this.menuService);
//
//    }
//}
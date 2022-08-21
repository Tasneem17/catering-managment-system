package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Category;
import za.ac.cput.factory.CategoryFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CategoryServiceImplTest {
    @Autowired
    private  CategoryServiceImpl categoryService;

    private  static Category  category = CategoryFactory.createCategory("Breakfast"
            ,"Egg Special");

    @Test
    @Order(1)
    void save() {
        System.out.printf("Saved");
        Category category_created =  this.categoryService.save(category);
        assertNotNull(category_created);
        System.out.printf(String.valueOf(category_created));
    }

    @Test
    @Order(2)
    void read() {
        Optional<Category> read = this.categoryService.read(category.getCategory_ID());
        assertEquals(read.get(),category.getCategory_ID());
        System.out.printf("Read " + read);
    }

    @Test
    @Order(4)
    void delete() {
        boolean deleted = this.categoryService.delete(this.category);
        assertTrue(deleted);
        System.out.println("Deleted:" + deleted);
    }

    @Test
    @Order(3)
    void deletebyid() {
        boolean deleted = this.categoryService.deletebyid(this.category.getCategory_ID());
        assertTrue(deleted);
        System.out.println("Deletedbyid:" + deleted);

    }

    @Test
    @Order(5)
    void findall() {
        this.categoryService.findall(category);
        System.out.println(this.categoryService);
    }
}
package za.ac.cput.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Food;
import za.ac.cput.entity.Menu;
import za.ac.cput.factory.FoodFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FoodServiceImplTest {
    @Autowired
    private  static  FoodServiceImpl foodService;

    private  static Food food = FoodFactory.createFood("Pancake and Coffe",
            "Diet Breakfast","2pancakes and one 100ml coffee",25);
    @Test
    @Order(1)
    void save() {
        System.out.printf("Saved");
        Food food_created =  this.foodService.save(food);
        assertNotNull(food_created);
        System.out.printf(String.valueOf(food_created));

    }

    @Test
    @Order(2)
    void read() {
        Optional<Food> read = this.foodService.read(food.getFood_ID());
        assertEquals(read.get(),food.getFood_ID());
        System.out.printf("Read " + read);

    }

    @Test
    @Order(4)
    void delete() {
        boolean deleted = this.foodService.delete(this.food);
        assertTrue(deleted);
        System.out.println("Deleted:" + deleted);
    }

    @Test
    @Order(3)
    void deletebyid() {
        boolean deleted = this.foodService.deletebyid(this.food.getFood_ID());
        assertTrue(deleted);
        System.out.println("Deletedbyid:" + deleted);
    }

    @Test
    @Order(5)
    void findall() {
        this.foodService.findall(food);
        System.out.println(this.foodService);
    }
}
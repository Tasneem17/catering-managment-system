/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Food;
import za.ac.cput.factory.FoodFactory;


import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class FoodRepositoryTest {

    private static FoodRepository repo = FoodRepository.getRepo();
    private static Food food = FoodFactory.createFood("Baked Chicken and potatos",
    "Spicy with sweet potatos","Single seriving prepackaged portion",50);



    @Test
    void a_create() {
        Food created  = repo.create(food);
        assertEquals(food.getFood_ID(),created.getFood_ID());
        System.out.println("Record created:"+created);
    }

    @Test
    void c_read() {
        Food read = repo.read(food.getFood_ID());
        assertNotNull(read);
        System.out.println("Reading Record:"+read);
    }

    @Test
    void b_update() {
        Food update =new Food.Builder().copy(food).setFood_Name("Lamb ribs")
                .setFood_Description("Roasted with rosemary spice").setFood_Quantity("2ribs per portion")
                .setFood_Price(70).build();
        assertNotNull(repo.update(update));
        System.out.println("Record updated:"+update);

    }

    @Test
    void e_delete() {
        boolean delete =repo.delete(food.getFood_ID());
        assertTrue(delete);
        System.out.println("Record deleted:"+delete);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all");
        System.out.println(repo.getAll());
    }

}
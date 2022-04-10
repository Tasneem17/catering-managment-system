/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {
@Test
    public void Test(){
    Food food = new Food.Builder().setFood_ID(1)
            .setFood_Name("Bacon and Eggs")
            .setFood_Description("Fried and poached with mayo sauce")
            .setFood_Quantity("Buffet")
            .setFood_Price(500)
            .build();
            System.out.println(food);

}
}
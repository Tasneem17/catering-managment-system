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

class CategoryTest {

    @Test
    public void Test() {
        Category category = new Category.Builder().setCategory_ID(String.valueOf(2))
                .setCategory_Name("BreakFast")
                .setCategory_Description("American breakfast ")
                .build();

        System.out.println(category);
    }
}
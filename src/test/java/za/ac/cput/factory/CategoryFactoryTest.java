package za.ac.cput.factory;

import com.google.gson.Gson;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
import za.ac.cput.entity.Category;

import javax.sound.midi.Soundbank;

import static org.junit.jupiter.api.Assertions.*;

class CategoryFactoryTest {
    @Test
    //Passing test
    public void test1(){
        Category cat = CategoryFactory.createCategory("554","Lunch"
                ,"Fried Food");
        Gson gSon = new Gson();
        String jsonString = gSon.toJson(cat);
        System.out.println(jsonString);
    }
  @AfterEach
    //Failing Test
    public void test2() {
        Category cat = CategoryFactory.createCategory("456","Lunch"
                , "MMMM");
        System.out.println(cat.toString());
    }
}
package za.ac.cput.service;

import za.ac.cput.entity.Food;

import java.util.List;

public interface FoodService extends  IService<Food, String>{
    //deleting by Food id
    boolean deletebyid(String id);
    //Find by id
    List<Food> findall(Food food);


}

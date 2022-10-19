package za.ac.cput.service;

import za.ac.cput.entity.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {

    Food read (String id);
    boolean deletebyid(String id);
    Food save(Food food);
    List<Food> findAll();


}

/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
package za.ac.cput.repository;



import za.ac.cput.entity.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodRepository implements IFoodRepository {
    private static FoodRepository repo = null;
    private List<Food> foodDB=null;

    public FoodRepository(){
         foodDB= new ArrayList<Food>();

    }
    public static FoodRepository getRepo(){
        if(repo==null){
            repo = new FoodRepository();
        }
        return repo;
    }
    @Override
    public Food create(Food food){
        boolean success =foodDB.add(food);
        if(!success)
            return null;
        return food;
    }
    @Override
    public  Food read(int Food_ID){
        for (Food f : foodDB){
            if(f.getFood_ID()==Food_ID)
                return f;
        }
        return null;
    }
    @Override
    public Food update(Food food){
        Food oldFood = read(food.getFood_ID());
        if(oldFood !=null){
            foodDB.remove(oldFood);
            foodDB.add(food);
            return food;
        }
        return null;
    }

    @Override
    public boolean delete(int Food_ID) {
        Food foodToDelete = read(Food_ID);
        if(foodToDelete == null) {
            System.out.println("Nothing to delete: ");
            return false;
        }
        foodDB.remove(foodToDelete);
        System.out.println("Delete success: ");
        return true;
    }
    public List<Food> getAll(){
        return foodDB;
    }
}

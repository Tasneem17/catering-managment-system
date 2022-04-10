package za.ac.cput.repository;


/*
 *Author :Alizwa Solibanzi
 * Student no: 220001499
 * APPLICATION DEVELOPMENT PRACTICE 3
 * ASSIGNMNET 1
 *
 */
import za.ac.cput.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private static CategoryRepository repo = null;
    private List<Category> catDB=null;

    public CategoryRepository(){
        catDB = new ArrayList<Category>();

    }
    public static CategoryRepository getRepo(){
        if(repo==null){
            repo = new CategoryRepository();
        }
        return repo;
    }
    @Override
    public Category create(Category cat){
        boolean success =catDB.add(cat);
        if(!success)
            return null;
        return cat;
    }
    @Override
    public  Category read(int Category_ID){
        for (Category m : catDB){
            if(m.getCategory_ID()==Category_ID)
                return m;
        }
        return null;
    }
    @Override
    public Category update(Category cat){
        Category oldCategory = read(cat.getCategory_ID());
        if(oldCategory !=null){
            catDB.remove(oldCategory);
            catDB.add(cat);
            return cat;
        }
        return null;
    }

    @Override
    public boolean delete(int Category_ID) {
        Category catToDelete = read(Category_ID);
        if(catToDelete == null) {
            System.out.println("Nothing to delete: ");
            return false;
        }
        catDB.remove(catToDelete);
        System.out.println("Delete success: ");
        return true;
    }
    public List<Category> getAll(){
        return catDB;
    }
}

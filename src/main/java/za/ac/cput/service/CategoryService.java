package za.ac.cput.service;
import za.ac.cput.entity.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService  {

    Category read (String id);
    boolean deletebyid(String id);

    Category save(Category category);
    List<Category> findAll();

}

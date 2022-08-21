package za.ac.cput.service;

import za.ac.cput.entity.Category;

import java.util.List;

public interface CategoryService extends IService<Category,String> {
    boolean deletebyid(String id);
    List<Category> findall(Category category);
}

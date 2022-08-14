package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.entity.Category;
import za.ac.cput.repository.ICategoryRepository;
import za.ac.cput.service.CategoryService;

import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {

    private ICategoryRepository categoryRepository;
    @Autowired

    public  CategoryServiceImpl(ICategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Optional<Category> read(String id) {
        return this.categoryRepository.findById(id);
    }

    @Override
    public void delete(Category category) {
     this.categoryRepository.delete(category);
    }
}

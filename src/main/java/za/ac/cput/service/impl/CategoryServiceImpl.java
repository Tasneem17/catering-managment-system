package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Category;
import za.ac.cput.repository.ICategoryRepository;
import za.ac.cput.service.CategoryService;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService {

    private final ICategoryRepository categoryRepository;
    @Autowired
    public  CategoryServiceImpl(ICategoryRepository categoryRepository)
    {this.categoryRepository = categoryRepository;}

    @Override
    public Category save(Category category) {return this.categoryRepository.save(category);
    }
    @Override
    public Category read(String id) {
        return this.categoryRepository.findById(id).orElse(null);
    }
    @Override
    public boolean deletebyid(String id) {
        this.categoryRepository.deleteById(id);
        return false;
    }
    @Override
    public List<Category> findAll() { return this.categoryRepository.findAll();}
}

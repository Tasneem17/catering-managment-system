package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Food;
import za.ac.cput.repository.IFoodRepository;
import za.ac.cput.service.FoodService;

import java.util.List;
import java.util.Optional;
@Service
public class FoodServiceImpl implements FoodService {

    private IFoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(IFoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }
    @Override
    public Food save(Food food)
    {
        return this.foodRepository.save(food);
    }
    @Override
    public Optional<Food> read(String id)
    {
        return this.foodRepository.findById(id);
    }

    @Override
    public boolean delete(Food food)
    {
        this.foodRepository.delete(food);
        return false;
    }

    @Override
    public boolean deletebyid(String id) {
        this.foodRepository.deleteById(id);
        return false;
    }

    @Override
    public List<Food> findall(Food food) {
        return this.foodRepository.getAll();
    }


}

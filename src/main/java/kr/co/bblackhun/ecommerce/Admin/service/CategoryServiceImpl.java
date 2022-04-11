package kr.co.bblackhun.ecommerce.Admin.service;

import kr.co.bblackhun.ecommerce.Admin.dto.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final MongoRepository mongoRepository;

    @Override
    public List<Category> getAllCategory() {
        return mongoRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        mongoRepository.save(category);
    }

    @Override
    public void removeCategoryById(String id) {
        mongoRepository.deleteById(id);
    }
}

package kr.co.bblackhun.ecommerce.Admin.service;

import kr.co.bblackhun.ecommerce.Admin.dto.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Category> getCategoryById(String id) {
        return mongoRepository.findById(id);
    }
}

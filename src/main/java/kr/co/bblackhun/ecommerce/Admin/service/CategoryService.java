package kr.co.bblackhun.ecommerce.Admin.service;

import kr.co.bblackhun.ecommerce.Admin.model.Category;

import java.util.List;
import java.util.Optional;


public interface CategoryService {

    List<Category> getAllCategory();

    void addCategory(Category category);

    void removeCategoryById(String id);

    Optional<Category> getCategoryById(String id);

}

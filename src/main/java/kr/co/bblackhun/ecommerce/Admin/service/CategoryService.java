package kr.co.bblackhun.ecommerce.Admin.service;

import kr.co.bblackhun.ecommerce.Admin.dto.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    List<Category> getAllCategory();

    void addCategory(Category category);

    void removeCategoryById(String id);

}

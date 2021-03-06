package kr.co.bblackhun.ecommerce.Admin.repository;

import kr.co.bblackhun.ecommerce.Admin.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {
}

package kr.co.bblackhun.ecommerce.Admin.repository;

import kr.co.bblackhun.ecommerce.Admin.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}

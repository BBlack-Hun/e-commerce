package kr.co.bblackhun.ecommerce.Admin.repository;

import kr.co.bblackhun.ecommerce.Admin.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findAllByCategoryId(String id);
}

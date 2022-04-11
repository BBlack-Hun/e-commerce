package kr.co.bblackhun.ecommerce.Admin.service;

import kr.co.bblackhun.ecommerce.Admin.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    void addProduct(Product product);

    void removeProductById(String id);

    Optional<Product> getProductById(String id);

    List<Product> getAllProductByCategoryId(String id);

}

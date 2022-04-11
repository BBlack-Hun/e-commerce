package kr.co.bblackhun.ecommerce.Admin.service;

import kr.co.bblackhun.ecommerce.Admin.model.Product;
import kr.co.bblackhun.ecommerce.Admin.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void removeProductById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProductByCategoryId(String id) {
        return productRepository.findAllByCategoryId(id);
    }
}

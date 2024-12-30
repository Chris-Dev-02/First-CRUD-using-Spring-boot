package com.SpringTest.SpringTest.service;

import org.springframework.stereotype.Service;
import com.SpringTest.SpringTest.entity.Product;
import com.SpringTest.SpringTest.repository.ProductRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(Integer id){
        return productRepository.findById(id);
    }

    public Product updateProduct(Integer id, Product updatedProduct){
        /*
        return productRepository.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
        }).orElseThrow(() -> new RuntimeException("Product not find with id " + id));*/
        Product product = productRepository.findById(id).get();
        //Setters
        return product;
    }

    public Boolean deleteById(Integer id){
        try{
            productRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}

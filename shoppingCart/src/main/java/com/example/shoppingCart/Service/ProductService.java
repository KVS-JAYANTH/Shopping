package com.example.shoppingCart.Service;

import com.example.shoppingCart.Entity.Product;
import com.example.shoppingCart.Entity.Reviews;
import com.example.shoppingCart.Repository.ProductRepository;
import com.example.shoppingCart.Repository.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ReviewsRepository reviewsRepository;

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @Transactional(readOnly = true)
    public List<Reviews> getAllReviews(){
        return reviewsRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Reviews> getReviewsByProductId(int productId){
        List<Reviews> reviews = reviewsRepository.findByProductId(productId);
        return reviews;
    }

    @Transactional(readOnly = true)
    public Product getProductById(int productId){
        Optional<Product> op = productRepository.findById(productId);
        if(op.isPresent())
            return op.get();
        throw new RuntimeException();
    }

    @Transactional
    public boolean addOrModifyProduct(Product product)
    {
        Product p = productRepository.save(product);
        return p != null;
    }

    @Transactional
    public boolean deleteProductById(int productId)
    {
        long count = productRepository.count();
        productRepository.deleteById(productId);
        return count > productRepository.count();
    }

    @Transactional(readOnly = true)
    public Product getProductByName(String productName)
    {
        Optional<Product> op = productRepository.findByProductName(productName);
        if (op.isPresent())
            return op.get();
        throw new RuntimeException();
    }
}
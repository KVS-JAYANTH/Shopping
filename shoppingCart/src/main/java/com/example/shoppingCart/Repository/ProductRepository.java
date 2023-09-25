package com.example.shoppingCart.Repository;

import com.example.shoppingCart.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    Optional<Product> findByProductName(String productName);
}
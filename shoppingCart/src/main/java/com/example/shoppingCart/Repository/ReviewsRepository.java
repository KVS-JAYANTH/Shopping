package com.example.shoppingCart.Repository;

import com.example.shoppingCart.Entity.Reviews;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewsRepository extends MongoRepository<Reviews, Integer> {
    List<Reviews> findByProductId(int productId);
}
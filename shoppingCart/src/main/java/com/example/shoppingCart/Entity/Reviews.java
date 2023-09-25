package com.example.shoppingCart.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;



@Document(collection = "reviews")
public class Reviews {

    @Id
    private ObjectId id;
    private int productId;

    private String feedback;

    public Reviews() {}

    public Reviews(int productId, String feedback) {
        this.productId = productId;
        this.feedback = feedback;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
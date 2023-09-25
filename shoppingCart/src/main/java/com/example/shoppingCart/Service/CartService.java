package com.example.shoppingCart.Service;

import com.example.shoppingCart.Entity.Cart;
import com.example.shoppingCart.Entity.Product;
import com.example.shoppingCart.Repository.CartRepository;
import com.example.shoppingCart.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    @Transactional(readOnly = true)
    public List<Cart> getAllProductsInCart(){
        return cartRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Cart getProductInCartById(int productId){
        Optional<Cart> op = cartRepository.findById(productId);
        if(op.isPresent())
            return op.get();
        throw new RuntimeException();
    }

    @Transactional
    public boolean addOrModifyProductInCart(Cart cart)
    {
        Cart p = cartRepository.save(cart);
        return p != null;
    }

    @Transactional
    public boolean deleteProductInCartById(int productId)
    {
        long count = cartRepository.count();
        cartRepository.deleteById(productId);
        return count > cartRepository.count();
    }
}
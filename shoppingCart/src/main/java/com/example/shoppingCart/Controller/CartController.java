package com.example.shoppingCart.Controller;

import com.example.shoppingCart.Entity.Cart;
import com.example.shoppingCart.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Cart>> getAllProductsInCart(){
        return new ResponseEntity<List<Cart>>(cartService.getAllProductsInCart(), HttpStatus.OK);
    }

    @GetMapping(value = "/{productId}", produces = "application/json")
    public ResponseEntity<Cart> getProductInCartById(@PathVariable int productId) // can also use (@PathVariable("productId") int pd)
    {
        Cart p = cartService.getProductInCartById(productId);
        return new ResponseEntity<Cart>(p, HttpStatus.OK);
    }

    //PostMapping is for adding a Object.
    @PostMapping(consumes = "application/json")
    public HttpStatus addProductToCart(@RequestBody Cart cart)
    {
        if (cartService.addOrModifyProductInCart(cart))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }

    @DeleteMapping("/{productId}")
    public HttpStatus deleteProductInCartById(@PathVariable int productId)
    {
        if (cartService.deleteProductInCartById(productId))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }

    @ExceptionHandler(RuntimeException.class)
    public HttpStatus cartNotFoundHandler()
    {
        return HttpStatus.NOT_FOUND;
    }
}

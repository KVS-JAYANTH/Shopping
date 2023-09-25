package com.example.shoppingCart.Controller;

import com.example.shoppingCart.Entity.Product;
import com.example.shoppingCart.Entity.Reviews;
import com.example.shoppingCart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping(value = "/{productId}", produces = "application/json")
    public ResponseEntity<Product> getProductById(@PathVariable int productId)
    {
        Product p = productService.getProductById(productId);
        return new ResponseEntity<Product>(p, HttpStatus.OK);
    }
    @GetMapping(value = "/reviews",produces = "application/json")
    @CrossOrigin(origins = {"http://localhost:8080","null"}, methods = {RequestMethod.GET})
    public ResponseEntity<List<Reviews>> getAllReviews(){
        return new ResponseEntity<List<Reviews>>(productService.getAllReviews(), HttpStatus.OK);
    }

    @GetMapping(value = "reviews/{productId}", produces = "application/json")
    @CrossOrigin(origins = {"http://localhost:8080","null"}, methods = {RequestMethod.GET})
    public ResponseEntity<List<Reviews>> getReviewsByProductId(@PathVariable int productId)
    {
        List<Reviews> r = productService.getReviewsByProductId(productId);
        return new ResponseEntity<List<Reviews>>(r, HttpStatus.OK);
    }

    //PostMapping is for adding a Object.
    @PostMapping(consumes = "application/json")
    public HttpStatus addProduct(@RequestBody Product product)
    {
        if (productService.addOrModifyProduct(product))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }

    @PutMapping(consumes = "application/json")
    public HttpStatus modifyProduct(@RequestBody Product product)
    {
        if (productService.addOrModifyProduct(product))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }

    @DeleteMapping("/{productId}")
    public HttpStatus deleteProductById(@PathVariable int productId)
    {
        if (productService.deleteProductById(productId))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }

    @GetMapping(value = "/productName/{productName}", produces = "application/json")
    public ResponseEntity<Product> getProductByName(@PathVariable String productName)
    {
        Product p = productService.getProductByName(productName);
        return new ResponseEntity<Product>(p, HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    public HttpStatus productNotFoundHandler()
    {
        return HttpStatus.NOT_FOUND;
    }
}

package com.example.shoppingCart.Controller;

import com.example.shoppingCart.Entity.Cart;
import com.example.shoppingCart.Entity.Orders;
import com.example.shoppingCart.Service.CartService;
import com.example.shoppingCart.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Orders>> getAllOrders(){
        return new ResponseEntity<List<Orders>>(ordersService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping(value = "/{orderId}", produces = "application/json")
    public ResponseEntity<Orders> getOrdersById(@PathVariable int orderId)
    {
        Orders p = ordersService.getOrdersById(orderId);
        return new ResponseEntity<Orders>(p, HttpStatus.OK);
    }

    //PostMapping is for adding a Object.
    @PostMapping(consumes = "application/json")
    public HttpStatus addOrders(@RequestBody Orders orders)
    {
        System.out.println(orders.toString());
        if (ordersService.addOrModifyOrders(orders))
            return HttpStatus.OK;
        return HttpStatus.NOT_MODIFIED;
    }


    @ExceptionHandler(RuntimeException.class)
    public HttpStatus orderNotFoundHandler()
    {
        return HttpStatus.NOT_FOUND;
    }
}

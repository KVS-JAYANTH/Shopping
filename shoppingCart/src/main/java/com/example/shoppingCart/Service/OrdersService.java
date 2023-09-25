package com.example.shoppingCart.Service;

import com.example.shoppingCart.Entity.Orders;
import com.example.shoppingCart.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Transactional(readOnly = true)
    public List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Orders getOrdersById(int orderId){
        Optional<Orders> op = ordersRepository.findById(orderId);
        if(op.isPresent())
            return op.get();
        throw new RuntimeException();
    }

    @Transactional
    public boolean addOrModifyOrders(Orders orders)
    {
        Orders p = ordersRepository.save(orders);
        return p != null;
    }

}
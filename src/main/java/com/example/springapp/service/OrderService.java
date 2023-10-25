package com.example.springapp.service;

import com.example.springapp.entity.TacoOrder;
import com.example.springapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void save(TacoOrder tacoOrder){
        orderRepository.save(tacoOrder);
    }
}

package com.viniciusogbr.webservice.services;

import com.viniciusogbr.webservice.entities.Order;
import com.viniciusogbr.webservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> optional = orderRepository.findById(id);
        return optional.get();
    }
}

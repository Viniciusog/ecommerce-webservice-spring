package com.viniciusogbr.webservice.repositories;

import com.viniciusogbr.webservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

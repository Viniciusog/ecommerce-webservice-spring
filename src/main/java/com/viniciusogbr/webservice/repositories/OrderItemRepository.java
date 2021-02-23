package com.viniciusogbr.webservice.repositories;

import com.viniciusogbr.webservice.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}

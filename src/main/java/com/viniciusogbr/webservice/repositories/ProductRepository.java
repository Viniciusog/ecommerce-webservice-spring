package com.viniciusogbr.webservice.repositories;

import com.viniciusogbr.webservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

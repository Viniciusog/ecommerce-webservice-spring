package com.viniciusogbr.webservice.repositories;

import com.viniciusogbr.webservice.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

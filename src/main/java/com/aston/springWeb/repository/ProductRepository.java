package com.aston.springWeb.repository;

import com.aston.springWeb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface ProductRepository extends Repository<Product,Long> , JpaRepository<Product,Long> {
    
}

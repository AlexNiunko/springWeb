package com.aston.springWeb.repository;

import com.aston.springWeb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface ProductRepository extends Repository<Product, Long>, JpaRepository<Product, Long> {


}

package com.aston.springWeb.repository;

import com.aston.springWeb.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface SaleRepository extends Repository<Sale,Long>, JpaRepository<Sale,Long> {
}

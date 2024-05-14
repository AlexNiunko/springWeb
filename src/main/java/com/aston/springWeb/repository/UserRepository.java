package com.aston.springWeb.repository;

import com.aston.springWeb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
@org.springframework.stereotype.Repository
public interface UserRepository extends Repository<User,Long>, JpaRepository<User,Long> {
}

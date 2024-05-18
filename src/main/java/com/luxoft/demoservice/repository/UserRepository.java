package com.luxoft.demoservice.repository;

import com.luxoft.demoservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
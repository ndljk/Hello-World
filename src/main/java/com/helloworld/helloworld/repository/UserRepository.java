package com.helloworld.helloworld.repository;

import com.helloworld.helloworld.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

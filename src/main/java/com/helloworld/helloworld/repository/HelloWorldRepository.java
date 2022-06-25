package com.helloworld.helloworld.repository;

import com.helloworld.helloworld.model.HelloWorld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloWorldRepository extends JpaRepository<HelloWorld, Long> {
    HelloWorld findByLangCode(String langCode);
}

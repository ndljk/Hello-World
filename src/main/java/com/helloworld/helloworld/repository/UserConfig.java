package com.helloworld.helloworld.repository;

import com.helloworld.helloworld.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@Configuration
public class UserConfig {
    private PasswordEncoder passwordEncoder;

    public UserConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner initUsers(UserRepository repository){
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("admin", passwordEncoder.encode("admin"), "ADMIN"));

        return args -> {
            repository.saveAll(users);
        };
    }
}

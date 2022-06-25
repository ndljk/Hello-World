package com.helloworld.helloworld.repository;

import com.helloworld.helloworld.model.HelloWorld;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class HelloWorldConfig {
    @Bean
    CommandLineRunner initHelloWorlds(HelloWorldRepository repository) {

        ArrayList<HelloWorld> languages = new ArrayList<HelloWorld>();
        languages.add(new HelloWorld("sr", "Serbian", "Zdravo svete!"));
        languages.add(new HelloWorld("de", "German", "Hallo Welt!"));
        languages.add(new HelloWorld("es", "Spanish", "Hola Mundo!"));
        languages.add(new HelloWorld("en", "English", "Hello World!"));
        languages.add(new HelloWorld("fr", "French", "Bonjour le monde!"));
        languages.add(new HelloWorld("ru", "Russian", "Привет, мир!"));
        languages.add(new HelloWorld("it", "Italian", "Ciao mondo!"));
        languages.add(new HelloWorld("tr", "Turkish", "Selam Dünya!"));
        languages.add(new HelloWorld("sv", "Swedish", "Hej världen!"));
        languages.add(new HelloWorld("cs", "Czech", "Ahoj světe!"));

        return args -> {
            repository.saveAll(languages);
        };
    }
}

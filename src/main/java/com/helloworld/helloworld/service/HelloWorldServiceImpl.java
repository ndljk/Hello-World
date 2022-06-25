package com.helloworld.helloworld.service;

import com.helloworld.helloworld.model.HelloWorld;
import com.helloworld.helloworld.repository.HelloWorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Autowired
    private HelloWorldRepository helloWorldRepository;

    @Override
    public List<HelloWorld> getAllHelloWorlds() {
        return helloWorldRepository.findAll();
    }

    @Override
    public HelloWorld getByLangCode(String code) {
        return  helloWorldRepository.findByLangCode(code);
    }

    @Override
    public void saveHelloWorldTranslation(HelloWorld helloWorld) {
        this.helloWorldRepository.save(helloWorld);
    }
}

package com.helloworld.helloworld.service;

import com.helloworld.helloworld.model.HelloWorld;

import java.util.List;

public interface HelloWorldService {
    List<HelloWorld> getAllHelloWorlds();

    HelloWorld getByLangCode(String code);

    void saveHelloWorldTranslation(HelloWorld helloWorld);
}

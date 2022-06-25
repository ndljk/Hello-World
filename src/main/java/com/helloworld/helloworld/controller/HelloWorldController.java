package com.helloworld.helloworld.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helloworld.helloworld.model.HelloWorld;

import com.helloworld.helloworld.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Controller
public class HelloWorldController {
    @Autowired
    private HelloWorldService helloWorldService;

    @Value("${spring.profiles.active:local}")
    private String activeProfile;

    @GetMapping("/api/hello-rest")
    @ResponseBody
    public String getHelloWorld(){
        return "Hello World!";
    }

    @GetMapping("/hello")
    public String viewAllHelloWorlds(Model model) {
        model.addAttribute("listHelloWorld", helloWorldService.getAllHelloWorlds());
        return "index";
    }

    @GetMapping("/api/hello")
    @ResponseBody
    public HelloWorld getHelloWorldByCode(@RequestParam String code) {
        return helloWorldService.getByLangCode(code);
    }

    @GetMapping("/secure/hello")
    @ResponseBody
    public List<HelloWorld> viewAllHelloWorldsSecured() {
        return helloWorldService.getAllHelloWorlds();
    }

    @GetMapping("/admin")
    public String showAdminPage(Model model){
        HelloWorld helloWorld=new HelloWorld();
        model.addAttribute("helloworld",helloWorld);
        return "admin";
    }

    @PostMapping("/saveTranslation")
    public String saveTranslation(@ModelAttribute("helloworld") HelloWorld helloWorld){
        helloWorldService.saveHelloWorldTranslation(helloWorld);
        return "redirect:/hello";
    }

    @GetMapping("/external/hello")
    @ResponseBody
    public String getApiTranslation(@RequestParam String code) throws IOException {
        if(!Objects.equals(activeProfile, "external"))
            return null;

        String apiKey="AIzaSyA-YOkr1zrazet8HQa1HsNPBV-q6QZKwrw";
        String url = "https://translation.googleapis.com/language/translate/v2?key="+apiKey;

        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> map = new HashMap<>();
        map.put("q","Hello World");
        map.put("target",code);
        map.put("format","text");

        HttpEntity<Map<String ,String>> entity = new HttpEntity<>(map);

        String response = restTemplate.exchange(url,HttpMethod.POST,entity,JsonNode.class)
                .getBody()
                .path("data")
                .toString();

        ObjectMapper mapper = new ObjectMapper();

        return mapper
                .readTree(response)
                .get("translations")
                .get(0)
                .get("translatedText")
                .toString();
    }
}


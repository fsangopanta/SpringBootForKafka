package com.example.providerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class KafkaController {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("test-kafka")
    public void testKafkaTemplate() {
        System.out.println("Iniciando el topic");
        kafkaTemplate.send("initialTopic", "Hola mundo desde kafka con spring boot");
    }
}

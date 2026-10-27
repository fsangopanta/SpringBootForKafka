package com.example.consumerservice.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;


@Configuration
public class KafkaConsumerListener {
    private Logger logger = LoggerFactory.getLogger(KafkaConsumerListener.class);


    @KafkaListener(topics = {"initialTopic"}, groupId = "group-id")
    public void listener(String message){
        logger.info("Mensaje recibido: {}", message);
    }
}

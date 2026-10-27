package com.example.providerservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {


    @Bean
    public NewTopic generateTopic() {
        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); // delete (borra mensaje) compact (mantiene el mas actual)public
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "8640000");  // Tiempo de retencion de mensajes - Defecto -1, es decir que no se van a eliminar nunca
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // Tamanio maximo del segmento - por defecto 1GB
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "100012"); // Tamanio maximo de cada mensaje - por defecto 1MB\

        return TopicBuilder.name("initialTopic")
                .partitions(2)
                .replicas(1)
                .configs(configurations)
                .build();
    }
}

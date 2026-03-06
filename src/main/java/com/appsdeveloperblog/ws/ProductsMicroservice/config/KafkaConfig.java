package com.appsdeveloperblog.ws.ProductsMicroservice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    NewTopic createTopic(){
        return TopicBuilder.name("products-created-events-topic")
                .partitions(3)
                .replicas(2)
                .configs(Map.of("min.insync.replicas", "2"))
                .build();
    }

}

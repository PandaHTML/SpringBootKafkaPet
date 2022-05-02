package com.krizhanovsky.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {
    @Bean
    public NewTopic jsonTopic(){
        return TopicBuilder.name("json").build();
    }

    @Bean
    public NewTopic xmlTopic(){return TopicBuilder.name("xml").build();}
}

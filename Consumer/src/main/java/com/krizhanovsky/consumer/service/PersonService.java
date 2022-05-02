package com.krizhanovsky.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krizhanovsky.consumer.entity.Person;
import com.krizhanovsky.consumer.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @KafkaListener(topics="petData",
            groupId="groupId")
    public void getPerson(String data) throws JsonProcessingException {
        System.out.println("Kafka Listener received: " + data);
        Person person = new ObjectMapper().readValue(data,Person.class);
        personRepository.save(person);
    }
}


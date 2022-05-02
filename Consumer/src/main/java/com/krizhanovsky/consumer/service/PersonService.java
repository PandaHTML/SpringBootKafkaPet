package com.krizhanovsky.consumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.krizhanovsky.consumer.entity.Person;
import com.krizhanovsky.consumer.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @KafkaListener(topics="json",
            groupId="groupId")
    public void getPersonInJson(String data) throws JsonProcessingException {
        System.out.println("Kafka Listener received: " + data);
        Person person = new ObjectMapper().readValue(data,Person.class);
        personRepository.save(person);
    }

    @KafkaListener(topics="xml",
            groupId="groupId")
    public void getPersonInXml(String data)  {
        personRepository.save(Objects.requireNonNull(DOMParser.parse(data)));
    }

}


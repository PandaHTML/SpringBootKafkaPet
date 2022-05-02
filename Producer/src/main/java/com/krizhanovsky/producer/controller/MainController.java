package com.krizhanovsky.producer.controller;

import com.krizhanovsky.producer.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MainController {

    @Autowired
    KafkaTemplate<String, Person> kafkaTemplate;

    @PostMapping(path = "/person")
    public void addNewPerson(@RequestBody Person person){
        System.out.println(person);
        kafkaTemplate.send("petData", person);
    }

}

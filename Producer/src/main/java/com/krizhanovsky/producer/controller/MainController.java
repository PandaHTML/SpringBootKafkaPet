package com.krizhanovsky.producer.controller;

import com.krizhanovsky.producer.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class MainController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping(value = "/json/person")
    public void addNewJsonPerson(@RequestBody String person){

        System.out.println(person);
        kafkaTemplate.send("json",person);
    }

    @PostMapping(value = "/xml/person")
    public void addNewXmlPerson(@RequestBody String person){

        System.out.println(person);
        kafkaTemplate.send("xml",person);
    }

}

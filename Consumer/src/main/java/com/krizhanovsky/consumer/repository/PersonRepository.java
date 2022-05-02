package com.krizhanovsky.consumer.repository;

import com.krizhanovsky.consumer.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Integer> {}

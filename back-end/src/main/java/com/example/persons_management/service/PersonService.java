package com.example.persons_management.service;

import com.example.persons_management.dto.request.CreatePersonRequest;
import com.example.persons_management.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
    Person getPerson(String id);
    List<Person> getAllPersons();
    Person createPerson(CreatePersonRequest createPersonRequest);
    Person updatePerson(String id, CreatePersonRequest createPersonRequest);
}

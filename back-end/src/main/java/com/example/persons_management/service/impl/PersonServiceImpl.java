package com.example.persons_management.service.impl;

import com.example.persons_management.dto.request.CreatePersonRequest;
import com.example.persons_management.entity.Person;
import com.example.persons_management.repository.PersonRepository;
import com.example.persons_management.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public Person getPerson(String id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person createPerson(CreatePersonRequest createPersonRequest) {
        Person person = new Person();
        person.setName(createPersonRequest.getName());
        person.setGender(createPersonRequest.getGender());
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(String id, CreatePersonRequest createPersonRequest) {
        Person updatePerson = personRepository.findById(id)
                .orElseThrow(() -> {
                    return new RuntimeException("Not found any person with id " +  id);
                });

        updatePerson.setName(createPersonRequest.getName());
        updatePerson.setGender(createPersonRequest.getGender());

        return personRepository.save(updatePerson);
    }

    @Override
    public void deletePerson(String id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person changeName(String id, String name) {
        Person updatedPerson = personRepository.findById(id)
                .orElseThrow(() -> {
                    return new RuntimeException("Not found any person with id " + id);
                });
        updatedPerson.setName(name);
        return personRepository.save(updatedPerson);
    }
}

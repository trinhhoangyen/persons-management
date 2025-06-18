package com.example.persons_management.controller;

import com.example.persons_management.dto.request.CreatePersonRequest;
import com.example.persons_management.entity.Person;
import com.example.persons_management.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping(value = "/getAllPersons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping(value = "/getPersonById/{id}")
    public Person getPersonById(@PathVariable String id) {
        return personService.getPerson(id);
    }

    @PostMapping(value = "/createPerson")
    public Person createPerson(@RequestBody CreatePersonRequest createPersonRequest){
        return personService.createPerson(createPersonRequest);
    }

    @PutMapping(value = "/updatePerson/{id}")
    public Person updatePerson(@PathVariable String id , @RequestBody CreatePersonRequest createPersonRequest) {
        return personService.updatePerson(id, createPersonRequest);
    }
}

package com.example.persons_management.controller;

import com.example.persons_management.dto.request.CreatePersonRequest;
import com.example.persons_management.entity.Person;
import com.example.persons_management.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @Operation(summary = "Get all users", description = "Returns a list of all users")
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @Operation(summary = "Get user by ID", description = "Return a single user by ID")
    @GetMapping(value = "/{id}")
    public Person getPersonById(@PathVariable String id) {
        return personService.getPerson(id);
    }

    @Operation(summary = "Create a new person", description = "Return the newly created person")
    @PostMapping
    @ApiResponse(responseCode = "200", description = "Person created successfully")
    @ApiResponse(responseCode = "400", description = "Valid input")
    public ResponseEntity createPerson(@RequestBody @Valid CreatePersonRequest createPersonRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            List<String> errors = new ArrayList<>();
            for(FieldError err: fieldErrors){
                errors.add(err.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        Person person = personService.createPerson(createPersonRequest);
        return ResponseEntity.ok().body(person);
    }

    @Operation(summary = "Edit person information", description = "Return the newly modified person")
    @PutMapping(value = "/{id}")
    public Person updatePerson(@PathVariable String id, @RequestBody CreatePersonRequest createPersonRequest) {
        return personService.updatePerson(id, createPersonRequest);
    }

    @Operation(summary = "Delete a person")
    @DeleteMapping(value = "/{id}")
    public void deletePerson(@PathVariable String id) {
        personService.deletePerson(id);
    }

    @Operation(summary = "Change name of person", description = "Return the newly modified person")
    @PatchMapping(value = "/{id}/name/{name}")
    public Person changeName(@PathVariable String id, @PathVariable String name) {
        return personService.changeName(id, name);
    }
}

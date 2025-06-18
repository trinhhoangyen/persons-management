package com.example.persons_management.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreatePersonRequest {
    private String name;
    private String gender;
}

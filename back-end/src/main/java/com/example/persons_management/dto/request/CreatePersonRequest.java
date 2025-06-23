package com.example.persons_management.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreatePersonRequest {
    @NotNull(message = "Name cannot be null")
    @Size(min=6, max=20, message = "Name must be at least 6 chars")
    private String name;
    private String gender;
}

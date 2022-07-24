package com.cassiorsfreitas.restapispring.http.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class GarmentDTO {
    
    @NotBlank
    private String name;

    @NotBlank
    private String description;
}

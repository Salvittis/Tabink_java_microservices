package br.com.investmentadvisor.profile.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {
    
    @NotBlank
    private String name;
    
    @NotBlank
    private String description;
}

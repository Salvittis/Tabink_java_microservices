package br.com.investmentadvisor.portfolio.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImpactDTO {
    
    @NotBlank
    private String name;
    
    @NotBlank
    private String description;
}

package br.com.investmentadvisor.advisor.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationDTO {
    
    @NotBlank
    private String name;
    
    @NotBlank
    private String description;
}

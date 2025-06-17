package br.com.investmentadvisor.activity.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    
    @NotBlank
    private String name;
    
    @NotBlank
    private String description;
}

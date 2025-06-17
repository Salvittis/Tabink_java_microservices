package br.com.investmentadvisor.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {
    private String name;
    private String email;
    private String token;
}

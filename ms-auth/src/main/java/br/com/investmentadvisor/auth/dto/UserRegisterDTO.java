package br.com.investmentadvisor.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserRegisterDTO {
    @NotBlank
    private String name;
    @Email
    private String email;
    private String password;
}

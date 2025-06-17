package br.com.investmentadvisor.auth.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.investmentadvisor.auth.dto.UserLoginDTO;
import br.com.investmentadvisor.auth.dto.UserRegisterDTO;
import br.com.investmentadvisor.auth.dto.UserResponseDTO;
import br.com.investmentadvisor.auth.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Auth Controller", description = "Gerencia autenticação e perfil do usuário da plataforma de investimento")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public void register(@Valid @RequestBody UserRegisterDTO dto) {
        userService.register(dto);
    }

    @PostMapping("/login")
    public UserResponseDTO login(@Valid @RequestBody UserLoginDTO dto) {
        return userService.login(dto);
    }

    @GetMapping("/me")
    public UserResponseDTO me() {
        return userService.getProfile();
    }
}


package br.com.investmentadvisor.management.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.investmentadvisor.management.dto.AdminDTO;
import br.com.investmentadvisor.management.service.AdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/management")
@RequiredArgsConstructor
@Tag(name = "AdminController", description = "Controlador para gerenciamento de Admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    public void create(@Valid @RequestBody AdminDTO dto) {
        adminService.create(dto);
    }

    @GetMapping
    public AdminDTO get() {
        return adminService.get();
    }
}

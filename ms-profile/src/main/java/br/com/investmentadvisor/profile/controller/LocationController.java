package br.com.investmentadvisor.profile.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.investmentadvisor.profile.dto.LocationDTO;
import br.com.investmentadvisor.profile.service.LocationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
@Tag(name = "ProfileController", description = "Controlador para gerenciamento de Perfil")
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    public void create(@Valid @RequestBody LocationDTO dto) {
        locationService.create(dto);
    }

    @GetMapping
    public LocationDTO get() {
        return locationService.get();
    }
}

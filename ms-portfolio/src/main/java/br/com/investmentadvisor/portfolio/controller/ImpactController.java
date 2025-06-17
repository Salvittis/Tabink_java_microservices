package br.com.investmentadvisor.portfolio.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.investmentadvisor.portfolio.dto.ImpactDTO;
import br.com.investmentadvisor.portfolio.service.ImpactService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
@Tag(name = "PortfolioController", description = "Controlador para gerenciamento de Portfolio")
public class ImpactController {

    private final ImpactService impactService;

    @PostMapping
    public void create(@Valid @RequestBody ImpactDTO dto) {
        impactService.create(dto);
    }

    @GetMapping
    public ImpactDTO get() {
        return impactService.get();
    }
}

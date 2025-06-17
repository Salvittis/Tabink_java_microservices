package br.com.investmentadvisor.advisor.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.investmentadvisor.advisor.dto.RecommendationDTO;
import br.com.investmentadvisor.advisor.service.RecommendationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/advisor")
@RequiredArgsConstructor
@Tag(name = "AdvisorController", description = "Controlador para gerenciamento de Advisor")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping
    public void create(@Valid @RequestBody RecommendationDTO dto) {
        recommendationService.create(dto);
    }

    @GetMapping
    public RecommendationDTO get() {
        return recommendationService.get();
    }
}

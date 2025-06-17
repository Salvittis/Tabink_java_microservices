package br.com.investmentadvisor.activity.controller;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.investmentadvisor.activity.dto.EventDTO;
import br.com.investmentadvisor.activity.service.EventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/activity")
@RequiredArgsConstructor
@Tag(name = "ActivityController", description = "Controlador para gerenciamento de Atividade")
public class EventController {

    private final EventService eventService;

    @PostMapping
    public void create(@Valid @RequestBody EventDTO dto) {
        eventService.create(dto);
    }

    @GetMapping
    public EventDTO get() {
        return eventService.get();
    }
}

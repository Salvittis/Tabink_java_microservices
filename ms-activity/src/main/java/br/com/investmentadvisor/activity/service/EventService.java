package br.com.investmentadvisor.activity.service;

import org.springframework.stereotype.Service;

import br.com.investmentadvisor.activity.dto.EventDTO;
import br.com.investmentadvisor.activity.model.Event;
import br.com.investmentadvisor.activity.repository.EventRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public void create(EventDTO dto) {
        Event event = Event.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
        eventRepository.save(event);
    }

    public EventDTO get() {
        return new EventDTO("Mock Name", "Mock Description");
    }
}

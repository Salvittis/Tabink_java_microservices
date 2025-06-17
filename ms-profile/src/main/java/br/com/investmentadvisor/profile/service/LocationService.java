package br.com.investmentadvisor.profile.service;

import org.springframework.stereotype.Service;

import br.com.investmentadvisor.profile.dto.LocationDTO;
import br.com.investmentadvisor.profile.model.Location;
import br.com.investmentadvisor.profile.repository.LocationRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public void create(LocationDTO dto) {
        Location location = Location.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
        locationRepository.save(location);
    }

    public LocationDTO get() {
        return new LocationDTO("Mock Name", "Mock Description");
    }
}

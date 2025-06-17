package br.com.investmentadvisor.portfolio.service;

import org.springframework.stereotype.Service;

import br.com.investmentadvisor.portfolio.dto.ImpactDTO;
import br.com.investmentadvisor.portfolio.model.Impact;
import br.com.investmentadvisor.portfolio.repository.ImpactRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImpactService {

    private final ImpactRepository impactRepository;

    public void create(ImpactDTO dto) {
        Impact impact = Impact.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
        impactRepository.save(impact);
    }

    public ImpactDTO get() {
        return new ImpactDTO("Mock Name", "Mock Description");
    }
}

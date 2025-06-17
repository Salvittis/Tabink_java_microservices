package br.com.investmentadvisor.advisor.service;

import org.springframework.stereotype.Service;

import br.com.investmentadvisor.advisor.dto.RecommendationDTO;
import br.com.investmentadvisor.advisor.model.Recommendation;
import br.com.investmentadvisor.advisor.repository.RecommendationRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    public void create(RecommendationDTO dto) {
        Recommendation recommendation = Recommendation.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
        recommendationRepository.save(recommendation);
    }

    public RecommendationDTO get() {
        return new RecommendationDTO("Mock Name", "Mock Description");
    }
}

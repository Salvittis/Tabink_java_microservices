package br.com.investmentadvisor.advisor.repository;

import br.com.investmentadvisor.advisor.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
}

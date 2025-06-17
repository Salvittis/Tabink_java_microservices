package br.com.investmentadvisor.portfolio.repository;

import br.com.investmentadvisor.portfolio.model.Impact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpactRepository extends JpaRepository<Impact, Long> {
}

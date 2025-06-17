package br.com.investmentadvisor.profile.repository;

import br.com.investmentadvisor.profile.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}

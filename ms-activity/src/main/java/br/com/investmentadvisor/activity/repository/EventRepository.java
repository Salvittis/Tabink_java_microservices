package br.com.investmentadvisor.activity.repository;

import br.com.investmentadvisor.activity.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}

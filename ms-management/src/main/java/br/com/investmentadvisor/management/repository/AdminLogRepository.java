package br.com.investmentadvisor.management.repository;

import br.com.investmentadvisor.management.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminLogRepository extends JpaRepository<Admin, Long> {
}

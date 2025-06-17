package br.com.investmentadvisor.management.service;

import org.springframework.stereotype.Service;

import br.com.investmentadvisor.management.dto.AdminDTO;
import br.com.investmentadvisor.management.model.Admin;
import br.com.investmentadvisor.management.repository.AdminRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public void create(AdminDTO dto) {
        Admin admin = Admin.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
        adminRepository.save(admin);
    }

    public AdminDTO get() {
        return new AdminDTO("Mock Name", "Mock Description");
    }
}

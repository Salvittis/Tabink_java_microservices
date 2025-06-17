package br.com.investmentadvisor.auth.service;

import org.springframework.stereotype.Service;

import br.com.investmentadvisor.auth.dto.UserLoginDTO;
import br.com.investmentadvisor.auth.dto.UserRegisterDTO;
import br.com.investmentadvisor.auth.dto.UserResponseDTO;
import br.com.investmentadvisor.auth.model.User;
import br.com.investmentadvisor.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void register(UserRegisterDTO dto) {
        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword()) // Em produção: hashear a senha
                .build();
        userRepository.save(user);
    }

    public UserResponseDTO login(UserLoginDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new RuntimeException("Senha incorreta");
        }

        return new UserResponseDTO(user.getName(), user.getEmail(), "mock-token-12345");
    }

    public UserResponseDTO getProfile() {
        return new UserResponseDTO("Usuário Mock", "mock@investmentadvisor.com", "mock-token-12345");
    }
}


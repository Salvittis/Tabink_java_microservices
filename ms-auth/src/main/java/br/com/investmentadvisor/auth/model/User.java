package br.com.investmentadvisor.auth.model;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "users") // <- aqui está a correção
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
}

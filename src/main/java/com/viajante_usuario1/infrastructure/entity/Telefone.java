package com.viajante_usuario1.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="telefone")
@Builder
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero", length = 15)
    private String numero;
    @Column(name = "ddd", length = 3)
    private String ddd;
    @Column(name = "usuario1_id")
    private Long usuario1_id;
}

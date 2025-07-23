package com.viajante_usuario1.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="endereco")
@Builder
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rua")
    private String rua;
    @Column(name = "cidade", length = 50)
    private String cidade;
    @Column(name = "estado", length = 20)
    private String estado;
    @Column(name = "cep",length = 15)
    private String cep;
    @Column(name = "usuario1_id")
    private Long usuario1_id;

}

package com.viajante_usuario1.business.dto;

import jakarta.persistence.Column;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TelefoneDTO {
    private Long id;
    private String numero;
    private String ddd;
}

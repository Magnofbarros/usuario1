package com.viajante_usuario1.business.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario1DTO {
    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTO>enderecos;
    private List<TelefoneDTO>telefones;
}

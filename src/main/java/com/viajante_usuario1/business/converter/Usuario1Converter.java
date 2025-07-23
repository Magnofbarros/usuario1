package com.viajante_usuario1.business.converter;

import com.viajante_usuario1.business.dto.EnderecoDTO;
import com.viajante_usuario1.business.dto.TelefoneDTO;
import com.viajante_usuario1.business.dto.Usuario1DTO;
import com.viajante_usuario1.infrastructure.entity.Endereco;
import com.viajante_usuario1.infrastructure.entity.Telefone;
import com.viajante_usuario1.infrastructure.entity.Usuario1;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Usuario1Converter {
    public Usuario1 paraUsuario1(Usuario1DTO usuario1DTO) {
        return Usuario1.builder()
                .nome(usuario1DTO.getNome())
                .senha(usuario1DTO.getSenha())
                .email(usuario1DTO.getEmail())
                .enderecos(paraListaEndereco(usuario1DTO.getEnderecos()))
                .telefones(paraListaTelefone(usuario1DTO.getTelefones()))
                .build();
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS) {
        return enderecoDTOS.stream().map(this::paraEndereco).toList();
    }

    public Telefone paraTelefone(TelefoneDTO telefoneDTO) {
        return Telefone.builder()
                .numero(telefoneDTO.getNumero())
                .ddd(telefoneDTO.getDdd())
                .build();
    }

    public List<Telefone> paraListaTelefone(List<TelefoneDTO> telefoneDTOS) {
        return telefoneDTOS.stream().map(this::paraTelefone).toList();
    }

    public Usuario1DTO paraUsuario1DTO(Usuario1 usuario1DTO) {
        return Usuario1DTO.builder()
                .nome(usuario1DTO.getNome())
                .senha(usuario1DTO.getSenha())
                .email(usuario1DTO.getEmail())
                .enderecos(paraListaEnderecoDTO(usuario1DTO.getEnderecos()))
                .telefones(paraListaTelefoneDTO(usuario1DTO.getTelefones()))
                .build();
    }

    public EnderecoDTO paraEnderecoDTO(Endereco endereco) {
        return EnderecoDTO.builder()
                .id(endereco.getId())
                .rua(endereco.getRua())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .cep(endereco.getCep())
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecoDTOS) {
        return enderecoDTOS.stream().map(this::paraEnderecoDTO).toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefone) {
        return TelefoneDTO.builder()
                .id(telefone.getId())
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }

    public List<TelefoneDTO> paraListaTelefoneDTO(List<Telefone> telefoneDTOS) {
        return telefoneDTOS.stream().map(this::paraTelefoneDTO).toList();
    }

    public Usuario1 updateUsuario1(Usuario1DTO usuario1DTO, Usuario1 entity) {
        return Usuario1.builder()
                .nome(usuario1DTO.getNome() != null ? usuario1DTO.getNome() : entity.getNome())
                .id(entity.getId())
                .senha(usuario1DTO.getSenha() != null ? usuario1DTO.getSenha() : entity.getSenha())
                .email(usuario1DTO.getEmail() != null ? usuario1DTO.getEmail() : entity.getEmail())
                .enderecos(entity.getEnderecos())
                .telefones(entity.getTelefones())
                .build();

    }

    public Endereco updateEndereco(EnderecoDTO dto, Endereco entity) {
        return Endereco.builder()
                .id(entity.getId())
                .cidade(dto.getCidade() != null ? dto.getCidade() : entity.getCidade())
                .rua(dto.getRua() != null ? dto.getRua() : entity.getRua())
                .estado(dto.getEstado() != null ? dto.getEstado() : entity.getEstado())
                .cep(dto.getCep() != null ? dto.getCep() : entity.getCep())
                .build();

    }

    public Telefone updateTelefone(TelefoneDTO dto, Telefone entity) {
        return Telefone.builder()
                .id(entity.getId())
                .numero(dto.getNumero() != null ? dto.getNumero() : entity.getNumero())
                .ddd(dto.getDdd() != null ? dto.getDdd() : entity.getDdd())
                .build();

    }
    public Endereco paraEnderecoEntity(EnderecoDTO dto, Long idusuario1){
        return Endereco.builder()
                .rua(dto.getRua())
                .cidade(dto.getCidade())
                .estado(dto.getEstado())
                .cep(dto.getCep())
                .usuario1_id(idusuario1)
                .build();
    }
    public Telefone paraTelefoneEntity(TelefoneDTO dto, Long idusuario1){
        return Telefone.builder()
                .numero(dto.getNumero())
                .ddd(dto.getDdd())
                .usuario1_id(idusuario1)
                .build();
    }
}
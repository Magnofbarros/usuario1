package com.viajante_usuario1.business;

import com.viajante_usuario1.business.converter.Usuario1Converter;
import com.viajante_usuario1.business.dto.Usuario1DTO;
import com.viajante_usuario1.infrastructure.entity.Usuario1;
import com.viajante_usuario1.infrastructure.repository.Usuario1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Usuario1Service {
    private final Usuario1Repository usuario1Repository;
    private final Usuario1Converter usuario1Converter;

    public Usuario1DTO salvarUsuario1(Usuario1DTO usuario1DTO){
        Usuario1 usuario1 = usuario1Converter.paraUsuario1(usuario1DTO);
        return usuario1Converter.paraUsuario1DTO(usuario1Repository.save(usuario1));
    }
}

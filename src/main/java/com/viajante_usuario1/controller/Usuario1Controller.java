package com.viajante_usuario1.controller;

import com.viajante_usuario1.business.Usuario1Service;
import com.viajante_usuario1.business.dto.Usuario1DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario1")
@RequiredArgsConstructor
public class Usuario1Controller {
    private final Usuario1Service usuario1Service;

    public ResponseEntity<Usuario1DTO>salvarUsuario1(@RequestBody Usuario1DTO usuario1DTO){
        return ResponseEntity.ok(usuario1Service.salvarUsuario1(usuario1DTO));
    }
}

package com.viajante_usuario1.controller;

import com.viajante_usuario1.business.Usuario1Service;
import com.viajante_usuario1.business.dto.EnderecoDTO;
import com.viajante_usuario1.business.dto.TelefoneDTO;
import com.viajante_usuario1.business.dto.Usuario1DTO;

import com.viajante_usuario1.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario1")
@RequiredArgsConstructor
public class Usuario1Controller {
    private final Usuario1Service usuario1Service;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;


    @PostMapping
    public ResponseEntity<Usuario1DTO>salvarUsuario1(@RequestBody Usuario1DTO usuario1DTO){
        return ResponseEntity.ok(usuario1Service.salvarUsuario1(usuario1DTO));
    }
    @PostMapping("/login")
    public String login(@RequestBody Usuario1DTO usuario1DTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario1DTO.getEmail(),usuario1DTO.getSenha())
        );
        return "Bearer " + jwtUtil.generateToken(authentication.getName());
    }
    @GetMapping
    public ResponseEntity<Usuario1DTO>buscarUsuario1PorEmail(@RequestParam("email") String email){
        return ResponseEntity.ok(usuario1Service.buscarUsuario1PorEmail(email));
    }
    @DeleteMapping("/{email}")
    public ResponseEntity<Void>deleteUsuario1PorEmail(@PathVariable String email) {
        usuario1Service.deleteUsuario1PorEmail(email);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Usuario1DTO> atualizarDadosUsuario1
                                          (@RequestBody Usuario1DTO dto,
                                          @RequestHeader ("Authorization") String token) {
        return ResponseEntity.ok(usuario1Service.atualizarDadosUsuario1(token,dto));
    }
    @PutMapping("/endereco")
    public ResponseEntity<EnderecoDTO>atualizarEndereco(@RequestBody EnderecoDTO enderecoDTO,
                                                        @RequestParam("id") Long id){
        return ResponseEntity.ok(usuario1Service.atualizarEndereco(id, enderecoDTO));
    }
    @PutMapping("/telefone")
    public ResponseEntity<TelefoneDTO>atualizarTelefone(@RequestBody TelefoneDTO telefoneDTO,
                                                        @RequestParam("id") Long id){
        return ResponseEntity.ok(usuario1Service.atualizarTelefone(id, telefoneDTO));
    }

}

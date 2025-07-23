package com.viajante_usuario1.business;

import com.viajante_usuario1.business.converter.Usuario1Converter;
import com.viajante_usuario1.business.dto.EnderecoDTO;
import com.viajante_usuario1.business.dto.TelefoneDTO;
import com.viajante_usuario1.business.dto.Usuario1DTO;
import com.viajante_usuario1.infrastructure.entity.Endereco;
import com.viajante_usuario1.infrastructure.entity.Telefone;
import com.viajante_usuario1.infrastructure.entity.Usuario1;
import com.viajante_usuario1.infrastructure.exceptions.ConflictException;
import com.viajante_usuario1.infrastructure.exceptions.ResourceNotFoundException;
import com.viajante_usuario1.infrastructure.repository.EnderecoRepository;
import com.viajante_usuario1.infrastructure.repository.TelefoneRepository;
import com.viajante_usuario1.infrastructure.repository.Usuario1Repository;
import com.viajante_usuario1.infrastructure.security.JwtUtil;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Usuario1Service {
    private final Usuario1Repository usuario1Repository;
    private final Usuario1Converter usuario1Converter;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final EnderecoRepository enderecoRepository;
    private final TelefoneRepository telefoneRepository;


    public Usuario1DTO salvarUsuario1(Usuario1DTO usuario1DTO){
        usuario1DTO.setSenha(passwordEncoder.encode(usuario1DTO.getSenha()));
        Usuario1 usuario1 = usuario1Converter.paraUsuario1(usuario1DTO);
        return usuario1Converter.paraUsuario1DTO(usuario1Repository.save(usuario1));
    }
    public void existeEmail(String email){
        try {
            boolean existe = verificarEmailExistente(email);
            if (existe){
                throw new ConflictException("Email ja cadastrado" + email);
            }
        }catch (ConflictException e ){
            throw new ConflictException("Email já cadastrado" + e.getCause());
        }
    }
    public boolean verificarEmailExistente(String email){
        return usuario1Repository.existsByEmail(email);
    }
    @Transactional
    public Usuario1DTO buscarUsuario1PorEmail(String email){
       try {
           return usuario1Converter.paraUsuario1DTO(
                   usuario1Repository.findByEmail(email).
                   orElseThrow(()->
                           new ResourceNotFoundException("Email não encontrado" + email))
           );
       } catch (ResourceNotFoundException e) {
           throw new ResourceNotFoundException("Email não encontrado" + email);
       }
    }

    public void deleteUsuario1PorEmail(String email){
        usuario1Repository.deleteByEmail(email);
    }
    public Usuario1DTO atualizarDadosUsuario1(String token, Usuario1DTO dto){
        //Aqui buscamoso email usuarios através do token(tirar obrigatoriedade do email)
        String email = jwtUtil.extrairEmailToken(token.substring(7));

        //Cripitografia de senha
        dto.setSenha(dto.getSenha()!= null? passwordEncoder.encode(dto.getSenha()) : null );

        // Busca dados do usuarios no banco dados
        Usuario1 usuarioEntity = usuario1Repository.findByEmail(email).orElseThrow(() ->
                new ResourceNotFoundException("Email não localizado"));

        //Mesclou os dados que recebemos da requisição DTO com os dados do banco de dados
        Usuario1 usuario1 = usuario1Converter.updateUsuario1(dto, usuarioEntity);

        // Salvou os dados do usuario convertido e depois pegou o retorno e converteu para DTO
        return usuario1Converter.paraUsuario1DTO(usuario1Repository.save(usuario1));
    }
    public EnderecoDTO atualizarEndereco(Long idEndereco, EnderecoDTO enderecoDTO) {
        Endereco entity = enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new ResourceNotFoundException("Id não encontrado: " + idEndereco));
        Endereco endereco = usuario1Converter.updateEndereco(enderecoDTO, entity);
        return usuario1Converter.paraEnderecoDTO( enderecoRepository.save(endereco));// ou outra lógica para montar o DTO atualizado
    }
    public TelefoneDTO atualizarTelefone(Long idTelefone, TelefoneDTO telefoneDTO) {
        Telefone entity = telefoneRepository.findById(idTelefone)
                .orElseThrow(() -> new ResourceNotFoundException("Id não encontrado: " + idTelefone));

        Telefone telefone = usuario1Converter.updateTelefone(telefoneDTO, entity);

        return usuario1Converter.paraTelefoneDTO(telefoneRepository.save(telefone));
    }
               // ou outra lógica para montar o DTO atualizado

}

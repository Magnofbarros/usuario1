package com.viajante_usuario1.infrastructure.repository;

import com.viajante_usuario1.infrastructure.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário.

    Optional<Endereco> findByCep(String cep);
    List<Endereco> findByCidade(String cidade);
}



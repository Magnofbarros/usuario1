package com.viajante_usuario1.infrastructure.repository;


import com.viajante_usuario1.infrastructure.entity.Usuario1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface Usuario1Repository extends JpaRepository<Usuario1, Long> {

    boolean existsByEmail(String email);

    Optional<Usuario1> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}

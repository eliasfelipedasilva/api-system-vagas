package io.github.eliasfelipedasilva.domain.repository;

import io.github.eliasfelipedasilva.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Usuarios extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM `usuario` WHERE usuario.vaga_id_vaga = :vaga", nativeQuery = true)
    List<Usuario> findByVaga(@Param("vaga") Integer vaga);

}
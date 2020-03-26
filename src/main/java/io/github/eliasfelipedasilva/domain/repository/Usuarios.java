package io.github.eliasfelipedasilva.domain.repository;

import io.github.eliasfelipedasilva.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface Usuarios extends JpaRepository<Usuario, Integer> {

    @Query(value = "select u from Usuario u where u.nome like :nome")
    List<Usuario> findByNomeLike(@Param("nome") String nome);
}

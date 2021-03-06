package io.github.eliasfelipedasilva.rest.controller;

import io.github.eliasfelipedasilva.domain.entity.Usuario;
import io.github.eliasfelipedasilva.domain.entity.Vaga;
import io.github.eliasfelipedasilva.domain.repository.Usuarios;
import io.github.eliasfelipedasilva.domain.repository.Vagas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {


    @Autowired
    private Usuarios usuarios;

    public UsuarioController(Usuarios usuarios) {
        this.usuarios = usuarios;
    }



    @GetMapping("/{cpf}")
    public Usuario getUsuarioById(@PathVariable Integer cpf){
       return usuarios.findById(cpf)
               .orElseThrow(()->
                       new ResponseStatusException(HttpStatus.NOT_FOUND,
                               "Usuario nao encontrado"));

    }

    @RequestMapping(value="/cadastro", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario){
       return usuarios.save(usuario);
    }



    @DeleteMapping("{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void delete(@PathVariable Integer cpf){

        usuarios.findById(cpf)
                .map(usuario -> {
                    usuarios.delete(usuario);
                    return  usuario;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Usuario nao encontrado"));

    }

    @PutMapping("{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void update(@PathVariable Integer cpf, @RequestBody Usuario usuario){

         usuarios
                .findById(cpf)
                .map(usuarioExistente -> {
                    usuario.setCpf(usuarioExistente.getCpf());
                    usuarios.save(usuario);
                    return usuarioExistente;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Usuario nao encontrado"));

    }

    @GetMapping
    public List<Usuario> find(Usuario filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);


        Example example = Example.of(filtro, matcher);
        return usuarios.findAll(example);


    }

    @PutMapping("candidatar/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void candidatar(@PathVariable Integer cpf,  @RequestBody Usuario usuario){



        usuarios
                .findById(cpf)
                .map(usuarioExistente -> {
                    usuario.setCpf(usuarioExistente.getCpf());
                    usuarios.save(usuario);
                    return usuarioExistente;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Usuario nao encontrado"));

    }

    @GetMapping("vagas/{id}")
    public ResponseEntity<Collection<Usuario>> buscaPorVaga(@PathVariable int id){
        Collection<Usuario> todosUsuarios = usuarios.findByVaga(id);
        return  new ResponseEntity<>(todosUsuarios, HttpStatus.OK);
    }




}

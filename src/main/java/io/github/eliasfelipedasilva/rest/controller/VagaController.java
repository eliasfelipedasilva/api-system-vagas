package io.github.eliasfelipedasilva.rest.controller;

import io.github.eliasfelipedasilva.domain.entity.Usuario;
import io.github.eliasfelipedasilva.domain.entity.Vaga;
import io.github.eliasfelipedasilva.domain.repository.Usuarios;
import io.github.eliasfelipedasilva.domain.repository.Vagas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
@RequestMapping("/api/vagas")
public class VagaController {
    @Autowired
    private Vagas vagas;

    public VagaController(Vagas vagas) {
        this.vagas = vagas;
    }

    @GetMapping("/{id_vaga}")
    public Vaga getVagaByID(@PathVariable Integer id_vaga){
        return vagas.findById(id_vaga)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Vaga nao encontrado"));

    }

    @RequestMapping(value="/cadastro", method = RequestMethod.POST)
    public Vaga save( @RequestBody Vaga vaga) {
        return vagas.save(vaga);
    }




    @DeleteMapping("{id_vaga}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void delete(@PathVariable Integer id_vaga){

        vagas.findById(id_vaga)
                .map(vaga -> {
                    vagas.delete(vaga);
                    return  vaga;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Vaga nao encontrado"));

    }

    @PutMapping("{id_vaga}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void update(@PathVariable Integer id_vaga, @RequestBody Vaga vaga){

        vagas
                .findById(id_vaga)
                .map(vagaExistente -> {
                    vaga.setId_vaga(vagaExistente.getId_vaga());
                    vagas.save(vaga);
                    return vagaExistente;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Vaga nao encontrado"));

    }

    @GetMapping
    public List<Vaga> find(Vaga filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);


        Example example = Example.of(filtro, matcher);
        return vagas.findAll(example);


    }



}
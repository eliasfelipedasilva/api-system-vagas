package io.github.eliasfelipedasilva.domain.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "aplicada")
public class Aplicada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name = "cpf_usuario")
    private Integer cpf_usuario;


    @Column(name = "id_vaga")
    private Integer id_vaga;

    @Column(name = "data_aplicacao")
    private String data_aplicacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(Integer cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }

    public Integer getId_vaga() {
        return id_vaga;
    }

    public void setId_vaga(Integer id_vaga) {
        this.id_vaga = id_vaga;
    }

    public String getData_aplicacao() {
        return data_aplicacao;
    }

    public void setData_aplicacao(String data_aplicacao) {
        this.data_aplicacao = data_aplicacao;
    }
}


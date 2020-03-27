package io.github.eliasfelipedasilva.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "cpf" , length = 11)
    private Integer cpf;

    @Column(name = "nome", length = 120)
    private String nome;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "senha", length = 8)
    private String senha;

    @Column(name = "cargo_atual", length = 50)
    private String cargo_atual;

    @Column(name = "area_atual", length = 50)
    private String area_atual;

    
    @Column(name = "vaga_aplicada", length = 9)
    private Integer vaga_aplicada;

    public Integer getVaga_aplicada() {
        return vaga_aplicada;
    }

    public void setVaga_aplicada(Integer vaga_aplicada) {
        this.vaga_aplicada = vaga_aplicada;
    }

    public Usuario() {
    }

    public Usuario(Integer cpf, String nome, String email, String senha, String cargo_atual, String area_atual, Integer vaga_aplicada) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargo_atual = cargo_atual;
        this.area_atual = area_atual;
        this.vaga_aplicada = vaga_aplicada;
    }



    public Usuario(String nome) {
        this.nome = nome;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo_atual() {
        return cargo_atual;
    }

    public void setCargo_atual(String cargo_atual) {
        this.cargo_atual = cargo_atual;
    }

    public String getArea_atual() {
        return area_atual;
    }

    public void setArea_atual(String area_atual) {
        this.area_atual = area_atual;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "cpf=" + cpf +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", cargo_atual='" + cargo_atual + '\'' +
                ", area_atual='" + area_atual + '\'' +
                '}';
    }
}

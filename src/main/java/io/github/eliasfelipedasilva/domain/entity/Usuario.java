package io.github.eliasfelipedasilva.domain.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "cpf")
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

    @OneToMany(mappedBy = "cpf_usuario")
    private List<Aplicada> aplicadas;

    public List<Aplicada> getAplicadas() {
        return aplicadas;
    }

    public void setAplicadas(List<Aplicada> aplicadas) {
        this.aplicadas = aplicadas;
    }

    public Usuario() {
    }

    public Usuario(Integer cpf, String nome, String email, String senha, String cargo_atual, String area_atual) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cargo_atual = cargo_atual;
        this.area_atual = area_atual;
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

package io.github.eliasfelipedasilva.domain.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "vaga")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaga")
    private Long  id_vaga;

    @Column(name = "cargo_vaga")
    private String cargo_vaga;

    @Column(name = "descricao_vaga")
    private String descricao_vaga;

    @Column(name = "locacao_vaga")
    private String  locacao_vaga;

    @Column(name = "tipo_vaga")
    private String tipo_vaga;

    @Column(name = "data_vencimento_vaga")
    private String data_vencimento_vaga;

    @Column(name = "status_vaga")
    private String status_vaga;


    public Long getId_vaga() {
        return id_vaga;
    }

    public void setId_vaga(Long id_vaga) {
        this.id_vaga = id_vaga;
    }

    public String getCargo_vaga() {
        return cargo_vaga;
    }

    public void setCargo_vaga(String cargo_vaga) {
        this.cargo_vaga = cargo_vaga;
    }

    public String getDescricao_vaga() {
        return descricao_vaga;
    }

    public void setDescricao_vaga(String descricao_vaga) {
        this.descricao_vaga = descricao_vaga;
    }

    public String getLocacao_vaga() {
        return locacao_vaga;
    }

    public void setLocacao_vaga(String locacao_vaga) {
        this.locacao_vaga = locacao_vaga;
    }

    public String getTipo_vaga() {
        return tipo_vaga;
    }

    public void setTipo_vaga(String tipo_vaga) {
        this.tipo_vaga = tipo_vaga;
    }

    public String getData_vencimento_vaga() {
        return data_vencimento_vaga;
    }

    public void setData_vencimento_vaga(String data_vencimento_vaga) {
        this.data_vencimento_vaga = data_vencimento_vaga;
    }

    public String getStatus_vaga() {
        return status_vaga;
    }

    public void setStatus_vaga(String status_vaga) {
        this.status_vaga = status_vaga;
    }
}

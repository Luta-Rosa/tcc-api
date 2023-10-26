package com.example.tccapi.model;

import java.util.Objects;

public class Cidade {
    private Integer idCidade;
    private String nome;
    private String UF;

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return idCidade.equals(cidade.idCidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCidade);
    }
}

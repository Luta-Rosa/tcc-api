package com.example.tccapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name ="mapa")
public class Mapa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idMapa;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    public Integer getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(Integer idMapa) {
        this.idMapa = idMapa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mapa mapa = (Mapa) o;
        return idMapa.equals(mapa.idMapa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMapa);
    }
}


package com.example.tccapi.model;

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
    private Integer localizacao;

    public Integer getIdMapa() {
        return idMapa;
    }

    public void setIdMapa(Integer idMapa) {
        this.idMapa = idMapa;
    }

    public Integer getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Integer localizacao) {
        this.localizacao = localizacao;
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


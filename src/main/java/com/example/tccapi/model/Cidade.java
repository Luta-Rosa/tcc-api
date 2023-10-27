package com.example.tccapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name ="cidade")

public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idCidade;
    private String nome;
    private String UF;

    @JsonIgnore
    @OneToMany (mappedBy = "cidade")
    private List<Mapa> mapa = new ArrayList<>();

    @JsonIgnore
    @OneToMany (mappedBy = "cidade")
    private List<Usuarios> usuarios = new ArrayList<>();


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

    public List<Mapa> getMapaLocais() {
        return mapa;
    }

    public void setMapaLocais(List<Mapa> mapaLocais) {
        this.mapa = mapaLocais;
    }

    public List<Usuarios> getUsuariosCidade() {
        return usuarios;
    }

    public void setUsuariosCidade(List<Usuarios> usuariosCidade) {
        this.usuarios = usuariosCidade;
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

package com.example.tccapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name ="usuarios")

public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idUsuarios;
    private String nome;
    private String email;
    private String senha;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    @JsonIgnore
    @OneToMany(mappedBy = "usuarios")
    private List<MensagemChat> mensagens = new ArrayList<>();


    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
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

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<MensagemChat> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<MensagemChat> mensagens) {
        this.mensagens = mensagens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios usuarios = (Usuarios) o;
        return idUsuarios.equals(usuarios.idUsuarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuarios);
    }
}

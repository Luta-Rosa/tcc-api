package com.example.tccapi.model;

import javax.persistence.*;
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
    private String confirmaSenha;

    @ManyToOne
    @JoinColumn(name="idChat")
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "idMapa")
    private Mapa mapa;

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

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
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

package com.example.tccapi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="mensagemchat")

public class Mensagemchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idMsg;
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "id_usuarios")
    private Usuarios usuarios;


    public Integer getIdMsg() {
        return idMsg;
    }

    public void setIdMsg(Integer idMsg) {
        this.idMsg = idMsg;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mensagemchat that = (Mensagemchat) o;
        return idMsg.equals(that.idMsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMsg);
    }
}

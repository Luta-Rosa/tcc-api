package com.example.tccapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name ="chat")

public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idChat;
    private String mensagem;

    //muitos usuarios para um chat
    @JsonIgnore
    @OneToMany (mappedBy = "chat")
    private List<Usuarios> usuariosChat = new ArrayList<>();


    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<Usuarios> getUsuariosChat() {
        return usuariosChat;
    }

    public void setUsuariosChat(List<Usuarios> usuariosChat) {
        this.usuariosChat = usuariosChat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return idChat.equals(chat.idChat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChat);
    }
}

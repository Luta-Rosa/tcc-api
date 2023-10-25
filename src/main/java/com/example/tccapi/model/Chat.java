package com.example.tccapi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="chat")

public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idChat;
    private String mensagem;

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

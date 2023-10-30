package com.example.tccapi.repository;

import com.example.tccapi.model.Mensagemchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemChatRepository extends JpaRepository <Mensagemchat, Integer> {
}

package com.example.tccapi.repository;

import com.example.tccapi.model.MensagemChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemChatRepository extends JpaRepository <MensagemChat, Integer> {
}

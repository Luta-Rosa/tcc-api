package com.example.tccapi.repository;

import com.example.tccapi.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository <Chat, Integer> {
}

package com.example.socialNetwork.repository;

import com.example.socialNetwork.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}

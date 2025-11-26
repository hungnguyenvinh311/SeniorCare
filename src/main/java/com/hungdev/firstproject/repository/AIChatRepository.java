package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.AIChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AIChatRepository extends JpaRepository<AIChatEntity, Integer> {

    AIChatEntity findOneBySessionId(String sessionId);

    List<AIChatEntity> findByUserUserId(Integer userId);
}
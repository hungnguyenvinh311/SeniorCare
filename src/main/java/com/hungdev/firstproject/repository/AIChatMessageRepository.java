package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.AIChatMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AIChatMessageRepository extends JpaRepository<AIChatMessageEntity, Integer> {
}

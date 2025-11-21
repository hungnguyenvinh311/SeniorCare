package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.PrivateMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivateMessageRepository extends JpaRepository<PrivateMessageEntity, Integer> {

}

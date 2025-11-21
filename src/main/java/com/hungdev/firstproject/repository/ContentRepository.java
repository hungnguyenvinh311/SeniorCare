package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContentRepository extends JpaRepository<ContentEntity, Long> {
    List<ContentEntity> findByContenttype(String contenttype);
    void deleteAllByIdIn(List<Long> contentIds);
}
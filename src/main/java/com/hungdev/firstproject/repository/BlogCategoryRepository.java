package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.BlogCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogCategoryRepository extends JpaRepository<BlogCategoryEntity, Integer> {
}

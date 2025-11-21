package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<BlogEntity, Integer> {
    List<BlogEntity> findByCategoryName(String name);
    BlogEntity findByCategoryCategoryId(Integer categoryId);
}

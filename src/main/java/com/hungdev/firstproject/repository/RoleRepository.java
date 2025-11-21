package com.hungdev.firstproject.repository;

import com.hungdev.firstproject.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    RoleEntity findOneByCode(String code);
}
package com.hungdev.firstproject.repository;


import com.hungdev.firstproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByFullNameAndRoles_Code(String name, String roleCode);
    UserEntity findOneByFullName(String fullName);
    List<UserEntity> findByRoles_Code(String roleCode);
}

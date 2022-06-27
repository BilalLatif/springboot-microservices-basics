package com.msarchitecture.userservice.repository;

import com.msarchitecture.userservice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUserId(Long userId);
}

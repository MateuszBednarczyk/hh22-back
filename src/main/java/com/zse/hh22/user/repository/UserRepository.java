package com.zse.hh22.user.repository;

import com.zse.hh22.user.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByPESEL(Integer PESEL);
}

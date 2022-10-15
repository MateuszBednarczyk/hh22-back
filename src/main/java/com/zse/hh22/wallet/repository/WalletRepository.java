package com.zse.hh22.wallet.repository;

import com.zse.hh22.wallet.domain.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<WalletEntity, Long> {
    Optional<WalletEntity> findById(Long id);
}

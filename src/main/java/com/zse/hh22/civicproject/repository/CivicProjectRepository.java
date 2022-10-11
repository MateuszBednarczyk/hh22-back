package com.zse.hh22.civicproject.repository;

import com.zse.hh22.civicproject.domain.CivicProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CivicProjectRepository extends JpaRepository<CivicProjectEntity, Long> {

    Optional<CivicProjectEntity> findByTitle(String title);

    Optional<List<CivicProjectEntity>> findAllByCity(String city);
}

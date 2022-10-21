package com.zse.hh22.civicproject.mapper;

import com.zse.hh22.civicproject.api.CivicProjectDTO;
import com.zse.hh22.civicproject.domain.CivicProjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CivicProjectMapper {
    CivicProjectDTO mapEntityToDto(CivicProjectEntity civicProjectEntity);
}


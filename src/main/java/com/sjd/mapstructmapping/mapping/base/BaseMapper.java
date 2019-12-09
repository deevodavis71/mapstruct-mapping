package com.sjd.mapstructmapping.mapping.base;

import java.util.List;

import org.mapstruct.MappingTarget;

public interface BaseMapper<D, E>
{

    D toDto(E entity);

    E fromDto(D dto);

    void updateFromDto(D dto, @MappingTarget E entity);

    List<D> toDtoList(List<E> list);

    List<E> fromDtoList(List<D> list);

}


package com.foliapp.quoseservice.mapper;

public interface Mapper<R, E> {
    E fromResourceToEntity(R resource);
    R fromEntityToResource(E entity);
}

package com.foliapp.quoteservice.mapper;

public interface Mapper<R, E> {
    E fromResourceToEntity(R resource);
    R fromEntityToResource(E entity);
}

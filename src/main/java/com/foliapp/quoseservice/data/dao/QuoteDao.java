package com.foliapp.quoseservice.data.dao;

import com.foliapp.quoseservice.data.entity.QuoteEntity;

import java.util.List;

public interface QuoteDao {

    QuoteEntity save(QuoteEntity quote);

    List<QuoteEntity> getAll();
}

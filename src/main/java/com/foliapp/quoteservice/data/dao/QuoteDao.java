package com.foliapp.quoteservice.data.dao;

import com.foliapp.quoteservice.data.entity.QuoteEntity;

import java.util.List;

public interface QuoteDao {

    QuoteEntity save(QuoteEntity quote);

    List<QuoteEntity> getAll();
}

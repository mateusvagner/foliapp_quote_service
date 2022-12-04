package com.foliapp.quoteservice.data.dao.impl;

import com.foliapp.quoteservice.data.dao.QuoteDao;
import com.foliapp.quoteservice.data.entity.QuoteEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
@Transactional
public class PanacheQuoteDao implements QuoteDao, PanacheRepository<QuoteEntity> {

    @Override
    public QuoteEntity save(QuoteEntity quote) {
        persist(quote);
        return quote;
    }

    @Override
    public List<QuoteEntity> getAll() {
        return findAll().list();
    }
}

package com.foliapp.quoseservice.mapper.impl;

import com.foliapp.quoseservice.data.entity.QuoteEntity;
import com.foliapp.quoseservice.mapper.QuoteItemMapper;
import com.foliapp.quoseservice.mapper.QuoteMapper;
import com.foliapp.quoseservice.web.resource.QuoteResource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class StandardQuoteMapper implements QuoteMapper {

    @Inject
    QuoteItemMapper quoteItemMapper;

    @Override
    public QuoteEntity fromResourceToEntity(QuoteResource quote) {
        QuoteEntity entity = new QuoteEntity();
        entity.setId(quote.getId());
        entity.setProjectName(quote.getProjectName());
        entity.setCustomerId(quote.getCustomer().getId());
        entity.setQuoteItems(quoteItemMapper.fromResoucesEntities(quote.getQuoteItems()));

        return entity;
    }

    @Override
    public QuoteResource fromEntityToResource(QuoteEntity quote) {
        return null;
    }
}

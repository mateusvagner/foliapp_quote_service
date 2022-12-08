package com.foliapp.quoteservice.mapper.impl;

import com.foliapp.quoteservice.data.entity.QuoteEntity;
import com.foliapp.quoteservice.mapper.QuoteItemMapper;
import com.foliapp.quoteservice.mapper.QuoteMapper;
import com.foliapp.quoteservice.web.resource.QuoteResource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class StandardQuoteMapper implements QuoteMapper {

    @Inject
    QuoteItemMapper quoteItemMapper;

    @Override
    public QuoteEntity fromResourceToEntity(QuoteResource quote) {
        QuoteEntity entity = new QuoteEntity();
//        entity.setId(quote.getId());
        entity.setOwnerKeyIdentifier(quote.getOwnerKeyIdentifier());
        entity.setProjectName(quote.getProjectName());
        entity.setCustomerId(quote.getCustomer().getId());
        entity.setTotal(quote.getTotal());
        entity.setQuoteItems(quoteItemMapper.fromResoucesEntities(quote.getQuoteItems()));

        return entity;
    }

    @Override
    public QuoteResource fromEntityToResource(QuoteEntity quote) {
        return null;
    }
}

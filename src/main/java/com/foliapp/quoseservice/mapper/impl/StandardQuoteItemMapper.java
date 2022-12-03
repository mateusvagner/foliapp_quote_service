package com.foliapp.quoseservice.mapper.impl;

import com.foliapp.quoseservice.data.entity.QuoteItemEntity;
import com.foliapp.quoseservice.mapper.QuoteItemMapper;
import com.foliapp.quoseservice.web.resource.QuoteItemResource;

import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class StandardQuoteItemMapper implements QuoteItemMapper {

    @Override
    public QuoteItemEntity fromResourceToEntity(QuoteItemResource quoteItem) {
        QuoteItemEntity quoteItemEntity = new QuoteItemEntity();
        quoteItemEntity.setId(quoteItem.getId());
        quoteItemEntity.setItem(quoteItem.getItem());
        quoteItemEntity.setQuantity(quoteItem.getQuantity());
        return quoteItemEntity;
    }

    @Override
    public QuoteItemResource fromEntityToResource(QuoteItemEntity quoteItem) {
        QuoteItemResource quoteItemResource = new QuoteItemResource();
        quoteItemResource.setId(quoteItem.getId());
        quoteItemResource.setItem(quoteItem.getItem());
        quoteItemResource.setQuantity(quoteItem.getQuantity());
        return quoteItemResource;
    }

    @Override
    public List<QuoteItemResource> fromEntitiesToResouces(List<QuoteItemEntity> quoteItemEntities) {
        ArrayList<QuoteItemResource> quoteItemResources = new ArrayList<>();

        for (QuoteItemEntity quoteItem : quoteItemEntities) {
            quoteItemResources.add(fromEntityToResource(quoteItem));
        }

        return quoteItemResources;
    }

    @Override
    public List<QuoteItemEntity> fromResoucesEntities(List<QuoteItemResource> quoteItemResources) {
        ArrayList<QuoteItemEntity> quoteItemEntities = new ArrayList<>();

        for (QuoteItemResource quoteItem : quoteItemResources) {
            quoteItemEntities.add(fromResourceToEntity(quoteItem));
        }

        return quoteItemEntities;
    }
}

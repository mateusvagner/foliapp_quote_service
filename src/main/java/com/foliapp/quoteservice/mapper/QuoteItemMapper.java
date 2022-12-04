package com.foliapp.quoteservice.mapper;

import com.foliapp.quoteservice.data.entity.QuoteItemEntity;
import com.foliapp.quoteservice.web.resource.QuoteItemResource;

import java.util.List;

public interface QuoteItemMapper extends Mapper<QuoteItemResource, QuoteItemEntity>{

    List<QuoteItemResource> fromEntitiesToResouces(List<QuoteItemEntity> quoteItemEntities);

    List<QuoteItemEntity> fromResoucesEntities(List<QuoteItemResource> quoteItemResources);
}

package com.foliapp.quoseservice.mapper;

import com.foliapp.quoseservice.data.entity.QuoteItemEntity;
import com.foliapp.quoseservice.web.resource.QuoteItemResource;

import java.util.List;

public interface QuoteItemMapper extends Mapper<QuoteItemResource, QuoteItemEntity>{

    List<QuoteItemResource> fromEntitiesToResouces(List<QuoteItemEntity> quoteItemEntities);

    List<QuoteItemEntity> fromResoucesEntities(List<QuoteItemResource> quoteItemResources);
}

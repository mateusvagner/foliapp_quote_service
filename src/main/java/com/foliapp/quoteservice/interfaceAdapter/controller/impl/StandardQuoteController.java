package com.foliapp.quoteservice.interfaceAdapter.controller.impl;

import com.foliapp.quoteservice.data.dao.QuoteDao;
import com.foliapp.quoteservice.data.entity.QuoteEntity;
import com.foliapp.quoteservice.exception.CustomerNotFoundException;
import com.foliapp.quoteservice.interfaceAdapter.controller.QuoteController;
import com.foliapp.quoteservice.mapper.QuoteItemMapper;
import com.foliapp.quoteservice.mapper.QuoteMapper;
import com.foliapp.quoteservice.web.remoteService.RegisterRemoteService;
import com.foliapp.quoteservice.web.resource.CustomerResource;
import com.foliapp.quoteservice.web.resource.QuoteResource;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class StandardQuoteController implements QuoteController {

    @Inject
    @RestClient
    RegisterRemoteService registerRemoteService;

    @Inject
    QuoteMapper quoteMapper;

    @Inject
    QuoteItemMapper quoteItemMapper;

    @Inject
    QuoteDao quoteDao;

    @Override
    public QuoteResource saveQuote(QuoteResource quote) {
        CustomerResource customer = registerRemoteService.getCustomerById(quote.getCustomer().getId().toString());

        if (customer == null) {
            throw new CustomerNotFoundException(quote.getCustomer().getId().toString(), quote.getCustomer().getName());
        }

        quoteDao.save(quoteMapper.fromResourceToEntity(quote));

        return quote;
    }

    @Override
    public List<QuoteResource> getAllQuotes() {
        List<QuoteEntity> quoteEntities = quoteDao.getAll();
        List<QuoteResource> quotes = new ArrayList<>();

        for (QuoteEntity quoteEntity : quoteEntities) {
            String customerId = quoteEntity.getCustomerId().toString();
            CustomerResource customerResource = registerRemoteService.getCustomerById(customerId);

            QuoteResource quoteResource = new QuoteResource();
            quoteResource.setId(quoteEntity.getId());
            quoteResource.setOwnerKeyIdentifier(quoteEntity.getOwnerKeyIdentifier());
            quoteResource.setProjectName(quoteEntity.getProjectName());
            quoteResource.setCustomer(customerResource);
            quoteResource.setTotal(quoteEntity.getTotal());
            quoteResource.setQuoteItems(quoteItemMapper.fromEntitiesToResouces(quoteEntity.getQuoteItems()));

            quotes.add(quoteResource);
        }

        return quotes;
    }
}

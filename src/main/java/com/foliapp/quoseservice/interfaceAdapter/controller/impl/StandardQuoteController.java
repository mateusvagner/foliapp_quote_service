package com.foliapp.quoseservice.interfaceAdapter.controller.impl;

import com.foliapp.quoseservice.data.dao.QuoteDao;
import com.foliapp.quoseservice.data.entity.QuoteEntity;
import com.foliapp.quoseservice.exception.CustomerNotFoundException;
import com.foliapp.quoseservice.interfaceAdapter.controller.QuoteController;
import com.foliapp.quoseservice.mapper.QuoteItemMapper;
import com.foliapp.quoseservice.mapper.QuoteMapper;
import com.foliapp.quoseservice.web.remoteService.RegisterRemoteService;
import com.foliapp.quoseservice.web.resource.CustomerResource;
import com.foliapp.quoseservice.web.resource.QuoteResource;
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
            CustomerResource customerResource = registerRemoteService.getCustomerById(quoteEntity.getCustomerId().toString());

            QuoteResource quoteResource = new QuoteResource();
            quoteResource.setId(quoteEntity.getId());
            quoteResource.setProjectName(quoteEntity.getProjectName());
            quoteResource.setCustomer(customerResource);
            quoteResource.setQuoteItems(quoteItemMapper.fromEntitiesToResouces(quoteEntity.getQuoteItems()));

            quotes.add(quoteResource);
        }

        return quotes;
    }
}

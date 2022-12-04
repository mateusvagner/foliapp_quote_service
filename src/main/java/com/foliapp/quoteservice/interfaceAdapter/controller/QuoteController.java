package com.foliapp.quoteservice.interfaceAdapter.controller;

import com.foliapp.quoteservice.web.resource.QuoteResource;

import java.util.List;

public interface QuoteController {

    QuoteResource saveQuote(QuoteResource quote);

    List<QuoteResource> getAllQuotes();
}

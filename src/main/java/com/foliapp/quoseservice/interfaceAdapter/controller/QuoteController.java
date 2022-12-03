package com.foliapp.quoseservice.interfaceAdapter.controller;

import com.foliapp.quoseservice.web.resource.QuoteResource;

import java.util.List;

public interface QuoteController {

    QuoteResource saveQuote(QuoteResource quote);

    List<QuoteResource> getAllQuotes();
}

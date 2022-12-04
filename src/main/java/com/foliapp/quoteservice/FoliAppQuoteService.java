package com.foliapp.quoteservice;

import com.foliapp.quoteservice.exception.CustomerNotFoundException;
import com.foliapp.quoteservice.interfaceAdapter.controller.QuoteController;
import com.foliapp.quoteservice.web.resource.QuoteResource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/quote")
public class FoliAppQuoteService {

    @Inject
    QuoteController quoteController;

    @POST
    @Path("/new")
    @RolesAllowed("USER")
    @Produces(MediaType.APPLICATION_JSON)
    public QuoteResource postNewQuote(QuoteResource quote) {
        QuoteResource savedQuoteResource;

        try {
            savedQuoteResource = quoteController.saveQuote(quote);
        } catch (CustomerNotFoundException e) {
            throw new WebApplicationException(e.getMessage(), Response.Status.NOT_ACCEPTABLE);
        }

        return savedQuoteResource;
    }

    @GET
    @Path("/all")
    @RolesAllowed("USER")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public List<QuoteResource> getAllQuotes() {
        return quoteController.getAllQuotes();
    }
}
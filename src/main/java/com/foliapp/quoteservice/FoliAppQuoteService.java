package com.foliapp.quoteservice;

import com.foliapp.quoteservice.exception.CustomerNotFoundException;
import com.foliapp.quoteservice.interfaceAdapter.controller.QuoteController;
import com.foliapp.quoteservice.web.resource.QuoteResource;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/quote")
public class FoliAppQuoteService {

    @Inject
    QuoteController quoteController;

    @Claim(standard = Claims.kid)
    String keyIdentifier;

    @POST
    @Path("/new")
    @RolesAllowed("USER")
    @Produces(MediaType.APPLICATION_JSON)
    public QuoteResource postNewQuote(QuoteResource quote) {
        QuoteResource savedQuoteResource;

        try {
            quote.setOwnerKeyIdentifier(keyIdentifier);
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
        List<QuoteResource> allUserQuotes = new ArrayList<>();

        for (QuoteResource quote : quoteController.getAllQuotes()) {
            if (quote.getOwnerKeyIdentifier().equals(keyIdentifier)) {
                allUserQuotes.add(quote);
            }
        }

        return allUserQuotes;
    }
}
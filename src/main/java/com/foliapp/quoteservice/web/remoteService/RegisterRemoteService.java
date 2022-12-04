package com.foliapp.quoteservice.web.remoteService;

import com.foliapp.quoteservice.web.resource.CustomerResource;
import com.foliapp.quoteservice.web.resource.SupplierResource;
import io.quarkus.oidc.token.propagation.AccessToken;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RegisterRestClient(baseUri = "https://localhost:8443/register/")
@AccessToken
public interface RegisterRemoteService {

    @POST
    @Path("/supplier/new")
    @RolesAllowed("USER")
    @Produces(MediaType.APPLICATION_JSON)
    SupplierResource postNewSupplier(SupplierResource supplierResource);

    @GET
    @Path("/supplier/all")
    @RolesAllowed("USER")
    @Produces(MediaType.APPLICATION_JSON)
    List<SupplierResource> getAllSuppliers();

    @GET
    @Path("/supplier/{id}")
    @RolesAllowed("USER")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    SupplierResource getSupplierById(@PathParam("id") String id);

    @POST
    @Path("/customer/new")
    @RolesAllowed("USER")
    @Produces(MediaType.APPLICATION_JSON)
    CustomerResource postNewCustomer(CustomerResource customerResource);

    @GET
    @Path("/customer/{id}")
    @RolesAllowed("USER")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    CustomerResource getCustomerById(@PathParam("id") String id);

    @GET
    @Path("/customer/all")
    @RolesAllowed("USER")
    @Produces(MediaType.APPLICATION_JSON)
    List<CustomerResource> getAllCustomers();
}

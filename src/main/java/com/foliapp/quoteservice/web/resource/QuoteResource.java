package com.foliapp.quoteservice.web.resource;

import java.util.List;

public class QuoteResource {

    private Long id;
    private String projectName;
    private CustomerResource customer;

    private String total;
    private List<QuoteItemResource> quoteItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public CustomerResource getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResource customer) {
        this.customer = customer;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<QuoteItemResource> getQuoteItems() {
        return quoteItems;
    }

    public void setQuoteItems(List<QuoteItemResource> quoteItems) {
        this.quoteItems = quoteItems;
    }
}

package com.foliapp.quoteservice.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Quote")
public class QuoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String ownerKeyIdentifier;

    private String projectName;

    private Long customerId;

    private String total;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "quote_id")
    private List<QuoteItemEntity> quoteItems;

    public  QuoteEntity() {
        this.quoteItems = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwnerKeyIdentifier() {
        return ownerKeyIdentifier;
    }

    public void setOwnerKeyIdentifier(String ownerKeyIdentifier) {
        this.ownerKeyIdentifier = ownerKeyIdentifier;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<QuoteItemEntity> getQuoteItems() {
        return quoteItems;
    }

    public void setQuoteItems(List<QuoteItemEntity> quoteItems) {
        this.quoteItems = quoteItems;
    }
}

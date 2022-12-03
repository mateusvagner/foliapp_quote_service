package com.foliapp.quoseservice.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Quote")
public class QuoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String projectName;

    private Long customerId;

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

    public List<QuoteItemEntity> getQuoteItems() {
        return quoteItems;
    }

    public void setQuoteItems(List<QuoteItemEntity> quoteItems) {
        this.quoteItems = quoteItems;
    }
}

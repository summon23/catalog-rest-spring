package com.summon23.catalog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "product_vendor")
public class CatalogVendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double tierCogsPrice_1;

    @ManyToOne
    @JoinColumn(name = "product_variant_id")
    @JsonIgnore
    private Catalog catalog;

    public CatalogVendor() {
        super();
    }

    public CatalogVendor(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTierCogsPrice1() {
        return tierCogsPrice_1;
    }

    public void setTierCogsPrice1(Double tierCogsPrice1) {
        this.tierCogsPrice_1 = tierCogsPrice1;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}

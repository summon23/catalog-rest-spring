package com.summon23.catalog.controller;

import com.summon23.catalog.entity.Catalog;
import com.summon23.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("catalog")
public class CatalogController {

    @Autowired
    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping
    public List<Catalog> getAll() {
        return catalogService.findAll();
    }

    @GetMapping("/{id}")
    public Optional getCatalogById(@PathVariable(value = "id") Long catalogId) {
        return catalogService.findById(catalogId);
    }
}

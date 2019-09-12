package com.summon23.catalog.service;

import com.summon23.catalog.entity.Catalog;
import com.summon23.catalog.repository.CatalogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {
    private final CatalogRepository catalogRepository;

    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    public Optional<Catalog> findById(Long id) {
        return catalogRepository.findById(id);
    }

    public Catalog save(Catalog newCatalog) {
        return catalogRepository.save(newCatalog);
    }

    public void deleteById(Long id) {
        catalogRepository.deleteById(id);
    }

}

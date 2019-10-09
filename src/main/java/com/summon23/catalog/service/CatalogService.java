package com.summon23.catalog.service;

import com.summon23.catalog.entity.Catalog;
import com.summon23.catalog.repository.CatalogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {
    private final CatalogRepository catalogRepository;

    public CatalogService(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public List<Catalog> findAll(Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {
        Sort.Direction sortDirection =  sortOrder.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortDirection, sortBy));

        Page<Catalog> pagedResult = catalogRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Catalog>();
        }
    }

    public Page<Catalog> findAllWithPage(Pageable pageable) {
        return catalogRepository.findAll(pageable);
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

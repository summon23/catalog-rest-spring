package com.summon23.catalog.service;

import com.summon23.catalog.entity.CatalogVendor;
import com.summon23.catalog.repository.CatalogVendorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogVendorService {
    private final CatalogVendorRepository catalogVendorRepository;

    public CatalogVendorService(CatalogVendorRepository catalogVendorRepository) {
        this.catalogVendorRepository = catalogVendorRepository;
    }

    public List<CatalogVendor> findAll(Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {
        Sort.Direction sortDirection = sortOrder.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortDirection, sortBy));
        Page<CatalogVendor> pagedResult = catalogVendorRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<CatalogVendor>();
        }
    }
}

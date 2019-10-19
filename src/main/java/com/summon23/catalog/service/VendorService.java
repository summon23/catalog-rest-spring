package com.summon23.catalog.service;

import com.summon23.catalog.entity.Vendor;
import com.summon23.catalog.repository.VendorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public List<Vendor> findAll(Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {
        Sort.Direction sortDirection = sortOrder.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortDirection, sortBy));
        Page<Vendor> pagedResult = vendorRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Vendor>();
        }
    }
}

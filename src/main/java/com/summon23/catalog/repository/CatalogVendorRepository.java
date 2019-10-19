package com.summon23.catalog.repository;

import com.summon23.catalog.entity.CatalogVendor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogVendorRepository extends PagingAndSortingRepository<CatalogVendor, Long> {
}

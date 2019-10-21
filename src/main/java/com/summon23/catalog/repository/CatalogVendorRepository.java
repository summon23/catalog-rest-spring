package com.summon23.catalog.repository;

import com.summon23.catalog.entity.CatalogVendor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CatalogVendorRepository extends PagingAndSortingRepository<CatalogVendor, Long> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM product_vendor \\n-- #pageable\\n",
            countQuery = "SELECT count(*) FROM product_vendor"
    )
    Page<CatalogVendor> findByVendorId(Pageable page);
}

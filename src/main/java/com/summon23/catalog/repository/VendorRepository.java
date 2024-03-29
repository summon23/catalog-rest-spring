package com.summon23.catalog.repository;

import com.summon23.catalog.entity.Vendor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends PagingAndSortingRepository<Vendor, Long> {
}

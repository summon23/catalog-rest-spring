package com.summon23.catalog.repository;

import com.summon23.catalog.entity.Catalog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends PagingAndSortingRepository<Catalog, Long> {

}

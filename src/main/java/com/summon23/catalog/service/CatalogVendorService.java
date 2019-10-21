package com.summon23.catalog.service;

import com.summon23.catalog.entity.Catalog;
import com.summon23.catalog.entity.CatalogVendor;
import com.summon23.catalog.repository.CatalogVendorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CatalogVendorService {
    private final CatalogVendorRepository catalogVendorRepository;

    @PersistenceContext
    private EntityManager em;

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

    public List<CatalogVendor> getProductByVendor(String vendorUUID) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CatalogVendor> cq = cb.createQuery(CatalogVendor.class);

        Root catalogVendorRoot = cq.from(CatalogVendor.class);
        System.out.println(vendorUUID);
        Predicate authorNamePredicate = cb.equal(catalogVendorRoot.get("vendorId"), vendorUUID);
        cq.where(authorNamePredicate);

        TypedQuery<CatalogVendor> query = em.createQuery(cq);
        return query.getResultList();
    }
}

package com.summon23.catalog.controller;

import com.summon23.catalog.entity.CatalogVendor;
import com.summon23.catalog.entity.Vendor;
import com.summon23.catalog.service.CatalogVendorService;
import com.summon23.catalog.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("vendor")
public class VendorController {
    @Autowired
    private final VendorService vendorService;

    @Autowired
    private final CatalogVendorService catalogVendorService;

    public VendorController(VendorService vendorService, CatalogVendorService catalogVendorService) {
        this.vendorService = vendorService;
        this.catalogVendorService = catalogVendorService;
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                                      @RequestParam(defaultValue = "10") Integer pageSize,
                                                      @RequestParam(defaultValue = "id") String sortBy,
                                                      @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        List<Vendor> listVendor = vendorService.findAll(pageNo, pageSize, sortBy, sortOrder);

        return new ResponseEntity<List<Vendor>>(listVendor, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/catalog/{id}")
    public ResponseEntity<List<CatalogVendor>> getProductByVendor(
            @PathVariable(value = "id") String vendorId) {

        List<CatalogVendor> productByVendor = catalogVendorService.getProductByVendor(vendorId);

        return new ResponseEntity<List<CatalogVendor>>(productByVendor, new HttpHeaders(), HttpStatus.OK);
    }
}

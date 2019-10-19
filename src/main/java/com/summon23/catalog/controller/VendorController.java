package com.summon23.catalog.controller;

import com.summon23.catalog.entity.Vendor;
import com.summon23.catalog.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;

import java.util.List;

@RestController
@RequestMapping("vendor")
public class VendorController {
    @Autowired
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
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
}

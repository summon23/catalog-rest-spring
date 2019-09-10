package com.summon23.catalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("catalog")
public class CatalogController {

    @GetMapping
    public int getCatalogNum() {
        return 1;
    }
}

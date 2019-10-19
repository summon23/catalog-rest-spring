package com.summon23.catalog.controller;

import com.summon23.catalog.entity.Catalog;
import com.summon23.catalog.exception.CatalogNotFoundException;
import com.summon23.catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("catalog")
public class CatalogController {

    @Autowired
    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

//    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping
    public ResponseEntity<List<Catalog>> getAll(@RequestParam(defaultValue = "0") Integer pageNo,
                                @RequestParam(defaultValue = "10") Integer pageSize,
                                @RequestParam(defaultValue = "id") String sortBy,
                                @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        List<Catalog> listCatalog = catalogService.findAll(pageNo, pageSize, sortBy, sortOrder);

        return new ResponseEntity<List<Catalog>>(listCatalog, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public Page<Catalog> getCatalogWithPage(Pageable pageable) {
        return catalogService.findAllWithPage(pageable);
    }

    @GetMapping("/{id}")
    public Optional getCatalogById(@PathVariable(value = "id") Long catalogId) {
        return catalogService.findById(catalogId);
    }

    @PostMapping
    public Catalog createCatalog(Catalog catalog) {
        return catalogService.save(catalog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCatalog(@PathVariable(value = "id") Long catalogId) throws CatalogNotFoundException {
        Catalog catalog = catalogService.findById(catalogId).orElseThrow(() -> new CatalogNotFoundException(catalogId));

        catalogService.deleteById(catalogId);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/test")
    public ResponseEntity<String> testApi() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCatalog(
            @PathVariable(value = "id") Long catalogId,
            @RequestBody Map<String, String> newCatalog) throws CatalogNotFoundException {
        Catalog findCatalog = catalogService.findById(catalogId).orElseThrow(() -> new CatalogNotFoundException(catalogId));

        String newLongName = newCatalog.get("long_name");
        Catalog updated = catalogService.updateName(findCatalog, newLongName);
        if (newLongName.equals("TEST")) {
            throw new RuntimeException("thowing exception to test transaction rollback");
        }

        return ResponseEntity.ok().build();
    }
}

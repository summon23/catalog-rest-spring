package com.summon23.catalog.exception;

public class CatalogNotFoundException extends Exception{
    private Long catalogId;

    public CatalogNotFoundException(Long catalogId) {
        super(String.format("Book is not found with id : '%s'", catalogId));
    }
}

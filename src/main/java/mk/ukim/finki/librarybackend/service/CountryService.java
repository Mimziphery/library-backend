package mk.ukim.finki.librarybackend.service;

import mk.ukim.finki.librarybackend.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAll();
}

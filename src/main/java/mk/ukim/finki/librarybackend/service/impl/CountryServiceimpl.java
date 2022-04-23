package mk.ukim.finki.librarybackend.service.impl;

import mk.ukim.finki.librarybackend.model.Country;
import mk.ukim.finki.librarybackend.repository.CountryRepository;
import mk.ukim.finki.librarybackend.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceimpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceimpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }
}

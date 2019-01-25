package com.example.springboot.service.country;

import com.example.springboot.model.country.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public List<Country> findAll(){
        List<Country> countries = new ArrayList<>();

        repository.findAll().iterator().forEachRemaining(countries::add);

        return countries;
    }

    public Country load(String Cid) throws NoSuchElementException {
        return repository.findById(Cid).get();
    }

    public Country delete(String id) {
        repository.deleteById(id);
        return null;
    }

    public String create(Country country) {
        country.validate();

        if (repository.existsById(country.getCountryCode())) {
            throw new RuntimeException("Country already exists: " + country.getCountryCode() + ".");
        } else {
            return repository.save(country).getCountryCode();
        }

    }

    public String save(Country country) {
        country.validate();

        if (repository.existsById(country.getCountryCode())) {
            return repository.save(country).getCountryCode();
        } else {
            throw new RuntimeException("Country already exists: " + country.getCountryCode() + ".");
        }
    }
}

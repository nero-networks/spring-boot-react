package com.example.springboot.service.country;

import com.example.springboot.model.country.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, String> {

}

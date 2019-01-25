package com.example.springboot.api.v1;

import com.example.springboot.model.country.Country;
import com.example.springboot.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {

  @Autowired
  private CountryService service;

  @GetMapping
  public List<Country> findAll() {
    return service.findAll();
  }




  @GetMapping("/{id}")
  public Country load(@PathVariable String id) {
    return service.load(id);
  }

  @PostMapping("/{id}")
  public String save(@RequestBody Country country) { return service.save(country); }

  @PostMapping
  public String create(@RequestBody Country country) { return service.create(country); }

  @DeleteMapping("/{id}")
  public Country delete(@PathVariable String id) { return service.delete(id); }

}


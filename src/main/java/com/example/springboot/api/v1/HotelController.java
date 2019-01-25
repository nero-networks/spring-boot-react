package com.example.springboot.api.v1;

import com.example.springboot.model.hotel.Hotel;
import com.example.springboot.service.hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {

  @Autowired
  private HotelService service;

  @GetMapping
  public Page<Hotel> findHotels(@ModelAttribute Hotel hotel,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "5") int pageSize) {

    return service.findHotels(hotel, PageRequest.of(page, pageSize));
  }

  @GetMapping("/{id}")
  public Hotel load(@PathVariable String id) { return service.load(id); }

  @PostMapping("/{id}")
  public String save(@RequestBody Hotel hotel) { return service.save(hotel); }

  @PostMapping
  public String create(@RequestBody Hotel hotel) { return service.create(hotel); }

  @DeleteMapping("/{id}")
  public Hotel delete(@PathVariable String id) { return service.delete(id); }


}

package com.example.springboot.api.v1;

import com.example.springboot.model.hotel.Hotel;
import com.example.springboot.service.hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
  public Hotel load(@PathVariable Long id) {
    return service.load(id);
  }

  @PostMapping
  public Long save(@RequestBody Hotel hotel) {
    return service.save(hotel);
  }
}

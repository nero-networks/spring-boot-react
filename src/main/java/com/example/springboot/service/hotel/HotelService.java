package com.example.springboot.service.hotel;

import com.example.springboot.model.hotel.Hotel;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

  @Autowired
  private HotelRepository repository;

  /**
   * Search for Hotels by hotelCode, hotelName and chainCode.
   *
   * @param hotel A Hotel entity prototype.
   *              Populated with hotelCode, hotelName and chainCode used as search criteria.
   * @param pageable A Pageable
   * @return List of search results and paging informations.
   */
  public Page<Hotel> findHotels(Hotel hotel, Pageable pageable) {
    return repository.findByHotelCodeStartingWithAndHotelNameContainingAndChainCodeStartingWith(
      hotel.getHotelCode(), hotel.getHotelName(), hotel.getChainCode(), pageable
    );
  }

  /**
   * Search for Hotels by hotelCode.
   *
   * @param hotelCode A Hotel.hotelCode.
   * @return A Hotel
   */
  public Hotel findByHotelCode(String hotelCode) {
    return repository.findByHotelCode(hotelCode);
  }

  /**
   * Load a single Hotel entity by it's primary key.
   *
   * @param id The primary key of the Hotel entity to load.
   * @return A Hotel entity or null if the primary key does'nt exist in the database.
   * @throws NoSuchElementException if no element is found.
   */
  public Hotel load(Long id) throws NoSuchElementException {
    return repository.findById(id).get();
  }

  /**
   * Save a Hotel to the database as an upsert operation.
   *
   * @param hotel A Hotel entity to save.
   * @return the (maybe new) primary key
   */
  public Long save(Hotel hotel) {
    return repository.save(hotel).getId();
  }
}

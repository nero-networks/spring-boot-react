package com.example.springboot.service.hotel;

import com.example.springboot.model.country.Country;
import com.example.springboot.model.hotel.Hotel;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.Entity;
import javax.persistence.Id;

@Service
public class HotelService {

  @Autowired
  private HotelRepository repository;

  /**
   * Search for Hotels by hotelCode, hotelName and chainCode.
   *
   * @param hotel    A Hotel entity prototype.
   *                 Populated with hotelCode, hotelName and chainCode used as search criteria.
   * @param pageable A Pageable
   * @return List of search results and paging informations.
   */
  public Page<Hotel> findHotels(Hotel hotel, Pageable pageable) {
    return repository.findHotels(
            hotel.getHotelCode(), hotel.getHotelName(), hotel.getChainCode(),
            hotel.getStreet(), hotel.getPostalCode(), hotel.getCity(), hotel.getCountryCode(),
            pageable);
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
  public Hotel load(String id) throws NoSuchElementException {
    return repository.findById(id).get();
  }

  public Hotel delete(String id) {
    repository.deleteById(id);
    return null;
  }

  /**
   * Save a Hotel to the database as an upsert operation.
   *
   * @param hotel A Hotel entity to save.
   * @return the (maybe new) primary key
   */



  public String create(Hotel hotel) {
    hotel.validate();

    if (repository.existsById(hotel.getHotelName()) || repository.existsById(hotel.getHotelCode()) || repository.existsById(hotel.getChainCode())
        || repository.existsById(hotel.getStreet())) {
      throw new RuntimeException("Hotel name, code, chain or street already exists.");
    } else {
      repository.save(hotel).getHotelName();
      repository.save(hotel).getHotelCode();
      repository.save(hotel).getChainCode();
      repository.save(hotel).getStreet();
      repository.save(hotel).getPostalCode();
      repository.save(hotel).getCity();
      repository.save(hotel).getCountryCode();
      return null;
    }

  }

  public String save(Hotel hotel) {
    hotel.validate();

    if (repository.existsById(hotel.getHotelName()) || repository.existsById(hotel.getHotelCode()) || repository.existsById(hotel.getChainCode())
        || repository.existsById(hotel.getStreet())) {
      repository.save(hotel).getHotelName();
      repository.save(hotel).getHotelCode();
      repository.save(hotel).getChainCode();
      repository.save(hotel).getStreet();
      repository.save(hotel).getPostalCode();
      repository.save(hotel).getCity();
      repository.save(hotel).getCountryCode();
      return null;
    } else {
      throw new RuntimeException("Hotel already exists: " + hotel.getHotelName() + ".");
    }
  }
}

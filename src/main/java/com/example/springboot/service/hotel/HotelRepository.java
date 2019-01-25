package com.example.springboot.service.hotel;

import com.example.springboot.model.hotel.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, String> {
  Hotel findByHotelCode(String hotelCode);

  /**
   * Find by hotelCode startingWith AND hotelName containing AND chainCode startingWith.
   */
  @Query("SELECT h FROM Hotel h WHERE h.hotelCode LIKE CONCAT(:hotelCode, '%') " +
          "AND h.hotelName LIKE CONCAT('%', :hotelName, '%') " +
          "AND h.chainCode LIKE CONCAT(:chainCode, '%') " +
          "AND h.street LIKE CONCAT(:street, '%') " +
          "AND h.postalCode LIKE CONCAT(:postalCode, '%') " +
          "AND h.city LIKE CONCAT(:city, '%') " +
          "AND h.countryCode LIKE CONCAT(:countryCode, '%')")
  Page<Hotel> findHotels(
          String hotelCode, String hotelName, String chainCode,
          String street, String postalCode, String city, String countryCode,
          Pageable pageable);


}


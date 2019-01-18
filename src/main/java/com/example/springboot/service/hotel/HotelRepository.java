package com.example.springboot.service.hotel;

import com.example.springboot.model.hotel.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Long> {
  Hotel findByHotelCode(String hotelCode);

  /**
   * Find by hotelCode startingWith AND hotelName containing AND chainCode startingWith
   * @param hotelCode
   * @param hotelName
   * @param chainCode
   * @param pageable
   * @return
   */
  Page<Hotel> findByHotelCodeStartingWithAndHotelNameContainingAndChainCodeStartingWith(
      String hotelCode, String hotelName, String chainCode, Pageable pageable);
}

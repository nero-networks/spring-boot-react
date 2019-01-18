package com.example.springboot.model.hotel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String hotelCode = "";

  private String hotelName = "";

  private String chainCode = "";

  public Hotel() {}

  /**
   * Convinience constructor for creating new Hotel entities.
   *
   * @param hotelCode The hotel's code.
   * @param hotelName The hotel's name.
   * @param chainCode The chain's code the hotel is associated to.
   */
  public Hotel(String hotelCode, String hotelName, String chainCode) {
    this.hotelCode = hotelCode;
    this.hotelName = hotelName;
    this.chainCode = chainCode;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getHotelCode() {
    return hotelCode;
  }

  public void setHotelCode(String hotelCode) {
    this.hotelCode = hotelCode;
  }

  public String getHotelName() {
    return hotelName;
  }

  public void setHotelName(String hotelName) {
    this.hotelName = hotelName;
  }

  public String getChainCode() {
    return chainCode;
  }

  public void setChainCode(String chainCode) {
    this.chainCode = chainCode;
  }
}

package com.example.springboot.model.hotel;

import javax.persistence.*;

@Entity
public class Hotel {

  @Id
  private String hotelCode = "";

  private String hotelName = "";

  private String chainCode = "";

  private String street;

  private String postalCode;

  private String city;

  private String countryCode;

  public Hotel() {}

  /**
   * Convinience constructor for creating new Hotel entities.
   *
   * @param hotelCode The hotel's code.
   * @param hotelName The hotel's name.
   * @param chainCode The chain's code the hotel is associated to.
   */
  public Hotel(String hotelCode, String hotelName, String chainCode,
               String street, String postalCode, String city, String countryCode) {
    this.hotelCode = hotelCode;
    this.hotelName = hotelName;
    this.chainCode = chainCode;
    this.street = street;
    this.postalCode = postalCode;
    this.city = city;
    this.countryCode = countryCode;
  }

  public String getHotelCode() { return hotelCode; }

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

  public String getStreet() {
      return street;
  }

  public void setStreet(String street) {
      this.street = street;
  }

  public String getPostalCode() {
      return postalCode;
  }

  public void setPostalCode(String postalCode) {
      this.postalCode = postalCode;
  }

  public String getCity() {
      return city;
  }

  public void setCity(String city) {
      this.city = city;
  }

  public String getCountryCode() {
      return countryCode;
  }

  public void setCountryCode(String countryCode) {
      this.countryCode = countryCode;
  }

  public void validate() {

    if (hotelCode == null || hotelCode.length() == 0 || hotelCode.length() > 50) {
      throw new RuntimeException("Invalid hotelCode: " + hotelCode + ".");
    } else if (hotelName == null || hotelName.length() == 0 || hotelName.length() > 50) {
      throw new RuntimeException("Invalid hotelName: " + hotelName + ".");
    } else if (countryCode == null || countryCode.length() == 0 || countryCode.length() > 2) {
      throw new RuntimeException("Invalid countryCode: " + countryCode + ".");
    } else if (city == null || city.length() == 0 || city.length() > 50) {
      throw new RuntimeException("Invalid city: " + city + ".");
    } else if (street == null || street.length() == 0 || street.length() > 50) {
      throw new RuntimeException("Invalid street: " + street + ".");
    } else if (postalCode == null || postalCode.length() == 0 || postalCode.length() > 25) {
      throw new RuntimeException("Invalid postalCode: " + postalCode + ".");
    } else if (chainCode == null || chainCode.length() == 0 || chainCode.length() > 50) {
      throw new RuntimeException("Invalid chainCode: " + chainCode + ".");
    }
  }
}

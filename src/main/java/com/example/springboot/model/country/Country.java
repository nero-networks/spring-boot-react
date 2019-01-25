package com.example.springboot.model.country;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {

    @Id
    private String countryCode;

    private String countryName;

    public Country() {
    }

    public Country(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void validate() {

        if (countryCode == null || countryCode.length() == 0 || countryCode.length() > 2) {
            throw new RuntimeException("Invalid countryCode: " + countryCode);
        } else if (!countryCode.equals(countryCode.toUpperCase())) {
            throw new RuntimeException("Invalid countryCode: " + countryCode + " must be upper case");
        } else if (countryName == null || countryName.length() == 0 || countryName.length() > 50) {
            throw new RuntimeException("Invalid countryName: " + countryName);
        }

    }
}

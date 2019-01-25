package com.example.springboot;

import com.example.springboot.model.country.Country;
import com.example.springboot.model.hotel.Hotel;
import com.example.springboot.service.country.CountryRepository;
import com.example.springboot.service.hotel.HotelRepository;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  CommandLineRunner populateDatabase(HotelRepository hotels, CountryRepository countries) {
    return (args) -> {

      if (hotels.count() == 0) {
        hotels.saveAll(Arrays.asList(
                new Hotel("4711", "Hotel I", "47110", "Street I", "1", "City I", "DE"),
                new Hotel("4712", "Hotel II", "47111", "Street II", "2", "City II ", "US"),
                new Hotel("4713", "Hotel III", "47112", "Street III", "3", "City III", "UK"),
                new Hotel("4714", "Hotel IV", "47113", "Street IV", "4", "City IV", "AF"),
                new Hotel("4715", "Hotel V", "47114", "Street V", "5", "City V", "AX"),
                new Hotel("4716", "Hotel VI", "47115", "Street VI", "6", "City VI", "AL"),
                new Hotel("4717", "Hotel VII", "47116", "Street VII", "7", "City VII", "DZ"),
                new Hotel("4718", "Hotel VIII", "47117", "Street VIII", "8", "City VIII", "AS"),
                new Hotel("4719", "Hotel IX", "47118", "Street IX", "9", "City IX", "AD"),
                new Hotel("4720", "Hotel X", "47119", "Street X", "10", "City X", "AO"),
                new Hotel("4721", "Hotel XI", "471101", "Street XI", "11", "City XI", "AI"),
                new Hotel("4722", "Hotel XII", "471102", "Street XII", "12", "City XII", "AQ"),
                new Hotel("4723", "Hotel XIII", "471103", "Street XIII", "13", "City XIII", "AG"),
                new Hotel("4724", "Hotel XVI", "471104", "Street XIV", "14", "City XIV", "AR"),
                new Hotel("4725", "Hotel XV", "471105", "Street XV", "15", "City XV", "AM"),
                new Hotel("4726", "Hotel XVI", "471106", "Street XVI", "16", "City XVI", "AW"),
                new Hotel("4727", "Hotel XVII", "471107", "Street XVII", "17", "City XVII", "AU"),
                new Hotel("4728", "Hotel XVIII", "471108", "Street XVIII", "18", "City XVIII", "AT")));
      }

      if (countries.count() == 0) {
          countries.saveAll(Arrays.asList(
                new Country("DE", "Germany"),
                new Country("US", "United States"),
                new Country("UK", "United Kingdom"),
                new Country("AF", "Afghanistan"),
                new Country("AX", "Aland Islands"),
                new Country("AL", "Albania"),
                new Country("DZ", "Algeria"),
                new Country("AS", "American Samoa"),
                new Country("AD", "Andorra"),
                new Country("AO", "Angola"),
                new Country("AI", "Anguilla"),
                new Country("AQ", "Antarctica"),
                new Country("AG", "Antigua and Barbuda"),
                new Country("AR", "Argentina"),
                new Country("AM", "Armenia"),
                new Country("AW", "Aruba"),
                new Country("AU", "Australia"),
                new Country("AT", "Austria")

          ));
      }

    };
  }
}

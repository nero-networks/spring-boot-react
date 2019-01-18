package com.example.springboot;

import com.example.springboot.model.hotel.Hotel;
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
  CommandLineRunner populateHotels(HotelRepository hotels) {
    return (args) -> {
      if (hotels.count() == 0) {
        hotels.saveAll(Arrays.asList(
                new Hotel("4711", "Hotel I", "47110"),
                new Hotel("4712", "Hotel II", "47110"),
                new Hotel("4713", "Hotel III", "47110"),
                new Hotel("4714", "Hotel IV", "47110"),
                new Hotel("4715", "Hotel V", "47110"),
                new Hotel("4716", "Hotel VI", "47110"),
                new Hotel("4717", "Hotel VII", "47110"),
                new Hotel("4718", "Hotel VIII", "47110"),
                new Hotel("4719", "Hotel IX", "47110"),
                new Hotel("4720", "Hotel X", "47110"),
                new Hotel("4721", "Hotel XI", "47110"),
                new Hotel("4811", "Hotel II", "48110"),
                new Hotel("4812", "Hotel III", "48110"),
                new Hotel("4813", "Hotel VI", "48110"),
                new Hotel("4814", "Hotel V", "48110"),
                new Hotel("4815", "Hotel VI", "48110"),
                new Hotel("4816", "Hotel VII", "48110"),
                new Hotel("4817", "Hotel VIII", "48110")));
      }
    };
  }
}

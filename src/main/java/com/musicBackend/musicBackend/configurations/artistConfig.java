package com.musicBackend.musicBackend.configurations;

import com.musicBackend.musicBackend.models.Artist;
import com.musicBackend.musicBackend.repositories.artistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class artistConfig {
    //@Bean
    CommandLineRunner commandLineRunner(artistRepository repository) {
        return args -> {
            Artist Yuepeng = new Artist(
                    "Yuepengies",
                    "yanger@gmail.com",
                    "Music records Inc",
                    0,
                    "Lemonade",
                    LocalDate.of(2020, Month.OCTOBER, 15)
            );

            Artist Mike = new Artist(
                    "MikeNIke",
                    "Ike@gmail.com",
                    "Recordings Inc.",
                    120,
                    "Ikey",
                    LocalDate.of(2010, Month.JULY, 14)
            );

            repository.saveAll(List.of(Yuepeng, Mike));
        };
    }
}
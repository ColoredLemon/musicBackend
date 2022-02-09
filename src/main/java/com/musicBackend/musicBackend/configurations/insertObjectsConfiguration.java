package com.musicBackend.musicBackend.configurations;
import com.musicBackend.musicBackend.models.Artist;
import com.musicBackend.musicBackend.models.member;
import com.musicBackend.musicBackend.repositories.artistRepository;
import com.musicBackend.musicBackend.repositories.memberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class insertObjectsConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(memberRepository memberRepository, artistRepository artistRepository) {
        return args -> {
            member Yuepeng = new member(
                    "lemon",
                    "yuepeng",
                    "yang",
                    "yuepeng@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            member Mike = new member(
                    "mrMikey",
                    "Mike",
                    "beboo",
                    "Mike@gmail.com",
                    LocalDate.of(2008, Month.JANUARY, 5)
            );
            Artist Yuepengy = new Artist(
                    "Yuepengies",
                    "yanger@gmail.com",
                    "Music records Inc",
                    0,
                    "Lemonade",
                    LocalDate.of(2020, Month.OCTOBER, 15)
            );

            Artist Mikey = new Artist(
                    "MikeNIke",
                    "Ike@gmail.com",
                    "Recordings Inc.",
                    120,
                    "Ikey",
                    LocalDate.of(2010, Month.JULY, 14)
            );
            artistRepository.saveAll(List.of(Yuepengy, Mikey));
            memberRepository.saveAll(List.of(Yuepeng, Mike));
        };
    }
}

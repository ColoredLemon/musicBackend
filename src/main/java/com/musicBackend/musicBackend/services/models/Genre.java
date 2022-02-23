package com.musicBackend.musicBackend.services.models;

import javax.persistence.*;

@Entity
@Table
public class Genre {
    @Id
    @SequenceGenerator(
            name = "genre_sequence",
            sequenceName = "genre_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genre_sequence"
    )

    private Long id;
    private String Pop;
    private String Rap;
    private String Country;
    private String Electronic;
    private String Rock;

    public Genre(String pop, String rap, String country, String electronic, String rock, String jazz) {
        Pop = pop;
        Rap = rap;
        Country = country;
        Electronic = electronic;
        Rock = rock;
        Jazz = jazz;
    }

    public Genre(Long id, String pop, String rap, String country, String electronic, String rock, String jazz) {
        this.id = id;
        Pop = pop;
        Rap = rap;
        Country = country;
        Electronic = electronic;
        Rock = rock;
        Jazz = jazz;
    }

    public Genre(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPop() {
        return Pop;
    }

    public void setPop(String pop) {
        Pop = pop;
    }

    public String getRap() {
        return Rap;
    }

    public void setRap(String rap) {
        Rap = rap;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getElectronic() {
        return Electronic;
    }

    public void setElectronic(String electronic) {
        Electronic = electronic;
    }

    public String getRock() {
        return Rock;
    }

    public void setRock(String rock) {
        Rock = rock;
    }

    public String getJazz() {
        return Jazz;
    }

    public void setJazz(String jazz) {
        Jazz = jazz;
    }

    private String Jazz;

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", Pop='" + Pop + '\'' +
                ", Rap='" + Rap + '\'' +
                ", Country='" + Country + '\'' +
                ", Electronic='" + Electronic + '\'' +
                ", Rock='" + Rock + '\'' +
                ", Jazz='" + Jazz + '\'' +
                '}';
    }
}

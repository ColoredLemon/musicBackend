package com.musicBackend.musicBackend.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Artist {
    @Id
    @SequenceGenerator(
            name = "artist_sequence",
            sequenceName = "artist_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "artist_sequence"
    )

    private Long id;
    private String artistName;
    private String artistEmail;
    private String recordAffiliation;
    private int followerCount;
    private String artistNickname;
    private LocalDate dateJoined;
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "music_artist", joinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
    private Set<Music> musics;
    
    public Set<Music> getMusics() {
		return musics;
	}

	public void setMusics(Set<Music> musics) {
		this.musics = musics;
	}

	public Artist(String artistName, String artistEmail, String recordAffiliation, int followerCount, String artistNickname, LocalDate dateJoined) {
        this.artistName = artistName;
        this.artistEmail = artistEmail;
        this.recordAffiliation = recordAffiliation;
        this.followerCount = followerCount;
        this.artistNickname = artistNickname;
        this.dateJoined = dateJoined;
    }

    public Artist(Long id, String artistName, String artistEmail, String recordAffiliation, int followerCount, String artistNickname, LocalDate dateJoined) {
        this.id = id;
        this.artistName = artistName;
        this.artistEmail = artistEmail;
        this.recordAffiliation = recordAffiliation;
        this.followerCount = followerCount;
        this.artistNickname = artistNickname;
        this.dateJoined = dateJoined;
    }

    public Artist() {

    }

    public String getArtistEmail() {
        return artistEmail;
    }

    public void setArtistEmail(String artistEmail) {
        this.artistEmail = artistEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getRecordAffiliation() {
        return recordAffiliation;
    }

    public void setRecordAffiliation(String recordAffiliation) {
        this.recordAffiliation = recordAffiliation;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    public String getArtistNickname() {
        return artistNickname;
    }

    public void setArtistNickname(String artistNickname) {
        this.artistNickname = artistNickname;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", artistName='" + artistName + '\'' +
                ", recordAffiliation='" + recordAffiliation + '\'' +
                ", followerCount=" + followerCount +
                ", artistNickname='" + artistNickname + '\'' +
                ", dateJoined=" + dateJoined +
                '}';
    }
}

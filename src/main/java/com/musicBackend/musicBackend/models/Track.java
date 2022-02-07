package com.musicBackend.musicBackend.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Track {
    @Id
    @SequenceGenerator(
            name = "role_sequence",
            sequenceName = "role_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "role_sequence"
    )

    private Long id;
    private String trackName;
    private int trackMusicId;
    private Date trackDP;
    private String trackType;
    private String trackDesc;

    public Track(String trackName, int trackMusicId, Date trackDP, String trackType, String trackDesc) {
        this.trackName = trackName;
        this.trackMusicId = trackMusicId;
        this.trackDP = trackDP;
        this.trackType = trackType;
        this.trackDesc = trackDesc;
    }

    public Track(Long id, String trackName, int trackMusicId, Date trackDP, String trackType, String trackDesc) {
        this.id = id;
        this.trackName = trackName;
        this.trackMusicId = trackMusicId;
        this.trackDP = trackDP;
        this.trackType = trackType;
        this.trackDesc = trackDesc;
    }

    public Track(){

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getTrackMusicId() {
        return trackMusicId;
    }

    public void setTrackMusicId(int trackMusicId) {
        this.trackMusicId = trackMusicId;
    }

    public Date getTrackDP() {
        return trackDP;
    }

    public void setTrackDP(Date trackDP) {
        this.trackDP = trackDP;
    }

    public String getTrackType() {
        return trackType;
    }

    public void setTrackType(String trackType) {
        this.trackType = trackType;
    }

    public String getTrackDesc() {
        return trackDesc;
    }

    public void setTrackDesc(String trackDesc) {
        this.trackDesc = trackDesc;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", trackName='" + trackName + '\'' +
                ", trackMusicId=" + trackMusicId +
                ", trackDP=" + trackDP +
                ", trackType='" + trackType + '\'' +
                ", trackDesc='" + trackDesc + '\'' +
                '}';
    }
}

package com.musicBackend.musicBackend.services.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Music {
    @Id
    @SequenceGenerator(
            name = "music_sequence",
            sequenceName = "music_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "music_sequence"
    )

    private Long id;
    private String musicName;
    private String musicType;
    private Date musicDP;
    private String musicDesc;
    private float musicLength;

    public Music(String musicName, String musicType, Date musicDP, String musicDesc, float musicLength) {
        this.musicName = musicName;
        this.musicType = musicType;
        this.musicDP = musicDP;
        this.musicDesc = musicDesc;
        this.musicLength = musicLength;
    }

    public Music(Long id, String musicName, String musicType, Date musicDP, String musicDesc, float musicLength) {
        this.id = id;
        this.musicName = musicName;
        this.musicType = musicType;
        this.musicDP = musicDP;
        this.musicDesc = musicDesc;
        this.musicLength = musicLength;
    }

    public Music(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    public Date getMusicDP() {
        return musicDP;
    }

    public void setMusicDP(Date musicDP) {
        this.musicDP = musicDP;
    }

    public String getMusicDesc() {
        return musicDesc;
    }

    public void setMusicDesc(String musicDesc) {
        this.musicDesc = musicDesc;
    }

    public float getMusicLength() {
        return musicLength;
    }

    public void setMusicLength(float musicLength) {
        this.musicLength = musicLength;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", musicName='" + musicName + '\'' +
                ", musicType='" + musicType + '\'' +
                ", musicDP=" + musicDP +
                ", musicDesc='" + musicDesc + '\'' +
                ", musicLength=" + musicLength +
                '}';
    }
}

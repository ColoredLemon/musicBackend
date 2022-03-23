package com.musicBackend.musicBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class MusicCollection {
    @Id
    @SequenceGenerator(
            name = "music_collection_sequence",
            sequenceName = "music_collection_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "music_collection_sequence"
    )

    private Long id;
    private String name;
    @OneToMany
    @JsonIgnore
    @JoinTable(name = "track", joinColumns = @JoinColumn(name = "music_collection_sequence", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "playlist_sequence", referencedColumnName = "id"))
    private Set<PlayList> playLists;

    public MusicCollection(Long id, String name, Set<PlayList> playLists) {
        this.id = id;
        this.name = name;
        this.playLists = playLists;
    }

    public MusicCollection(String name, Set<PlayList> playLists) {
        this.name = name;
        this.playLists = playLists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<PlayList> getPlayLists() {
        return playLists;
    }

    public void setPlayLists(Set<PlayList> playLists) {
        this.playLists = playLists;
    }

    @Override
    public String toString() {
        return "MusicCollection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playLists=" + playLists +
                '}';
    }
}

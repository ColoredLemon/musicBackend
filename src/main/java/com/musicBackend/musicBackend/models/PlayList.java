package com.musicBackend.musicBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class PlayList {
    @Id
    @SequenceGenerator(
            name = "play_list_sequence",
            sequenceName = "play_list_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "play_list_sequence"
    )

    private Long id;
    private String name;
    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "play_list_track", joinColumns = @JoinColumn(name = "play_list_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "track_id", referencedColumnName = "id"))
    private Set<Track> tracks;

    public PlayList(Long id, String name, Set<Track> tracks) {
        this.id = id;
        this.name = name;
        this.tracks = tracks;
    }

    public PlayList(String name, Set<Track> tracks) {
        this.name = name;
        this.tracks = tracks;
    }

    public PlayList() {

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

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tracks=" + tracks +
                '}';
    }
}
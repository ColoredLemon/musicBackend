package com.musicBackend.musicBackend.services;

import com.musicBackend.musicBackend.models.Track;
import com.musicBackend.musicBackend.repositories.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {
    private final TrackRepository trackRepository;

    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }
    public List<Track> getTracks() {
        return trackRepository.findAll();
    }
    public void addNewTrack(Track Track) {
        Optional<Track> TrackOptional = trackRepository.findTrackById(Track.getId());
        if (TrackOptional.isPresent()) {
            throw new IllegalStateException("id is being used");
        }
        trackRepository.save(Track);
        System.out.println(Track);
    }

    public void deleteTrack(Long TrackId) {
        boolean exists = trackRepository.existsById(TrackId);
        if(!exists){
            throw new IllegalStateException("Track with id " + TrackId + " does not exists.");
        }
        trackRepository.deleteById((TrackId));
    }

    public Track getTrackById(Long TrackId){
        Optional<Track> trackOptional = trackRepository.findTrackById(TrackId);
        if (!trackOptional.isPresent()) {
            throw new IllegalStateException("Track doesn't exist");
        }
        return trackOptional.get();
    }
}

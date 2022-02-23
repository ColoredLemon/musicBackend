package com.musicBackend.musicBackend.services.services;

import com.musicBackend.musicBackend.models.Track;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class trackService {
    private final com.musicBackend.musicBackend.repositories.trackRepository trackRepository;

    public trackService(com.musicBackend.musicBackend.repositories.trackRepository trackRepository) {
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
}

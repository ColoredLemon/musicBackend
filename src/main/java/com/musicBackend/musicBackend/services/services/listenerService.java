package com.musicBackend.musicBackend.services.services;

import com.musicBackend.musicBackend.models.Listener;
import com.musicBackend.musicBackend.repositories.listenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class listenerService {

    private final com.musicBackend.musicBackend.repositories.listenerRepository listenerRepository;

    @Autowired
    public listenerService(listenerRepository listenerRepository) {
        this.listenerRepository = listenerRepository;
    }

    public List<Listener> getlistener() {

        return listenerRepository.findAll();
    }

    public void addNewListener(Listener listener) {
        Optional<Listener> listenerOptional = listenerRepository.findListenerByEmail(listener.getEmail());
        if (listenerOptional.isPresent()) {
            throw new IllegalStateException("email is being used");
        }
        listenerRepository.save(listener);
        System.out.println(listener);
    }

    public void deleteListener(Long listenerId) {
        boolean exists = listenerRepository.existsById(listenerId);
        if(!exists){
            throw new IllegalStateException("listener with id " + listenerId + " does not exists.");
        }
        listenerRepository.deleteById((listenerId));
    }

}

package com.musicBackend.musicBackend.controllers;

import com.musicBackend.musicBackend.models.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ListenerController {
    private final com.musicBackend.musicBackend.services.listenerService listenerService;

    @Autowired
    public ListenerController(com.musicBackend.musicBackend.services.listenerService listenerService) {
        this.listenerService = listenerService;
    }

    @GetMapping//("getListeners")
    public List<Listener> getlistener(){

        return listenerService.getlistener();
    }

    @PostMapping("addListener")
    public void registerNewListener(@RequestBody Listener listener) {

        listenerService.addNewListener(listener);
    }

    @DeleteMapping(path = "{listenerId}")
    public void deletelistener(@PathVariable("listenerId") Long listenerId){

        listenerService.deleteListener(listenerId);
    }
}

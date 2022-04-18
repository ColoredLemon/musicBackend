package com.musicBackend.musicBackend.controllers;
import com.musicBackend.musicBackend.models.Member;
import org.springframework.ui.Model;
import com.musicBackend.musicBackend.models.Listener;
import com.musicBackend.musicBackend.services.ListenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@RequestMapping(path = "listener")
public class ListenerController {
    private final ListenerService listenerService;

    @Autowired
    public ListenerController(ListenerService listenerService) {
        this.listenerService = listenerService;
    }

    @GetMapping("/getListeners")
    public String getlistener(Model model){
        model.addAttribute("getListener",listenerService.getlistener());
        return "listener";
    }

    @GetMapping("/addListener")
    public String registerNewListener(Model model) {
        Listener listener = new Listener();
        model.addAttribute("listener",listener);
        return "newListner";
    }
    @PostMapping("/saveListener")
    public String saveEmployee(@ModelAttribute("listener") Listener listener) {
        listenerService.addNewListener(listener);
        return "redirect:/";
    }

    @DeleteMapping(path = "/deleteListener/{listenerId}")
    public String deletelistener(@PathVariable("listenerId") Long listenerId){
        listenerService.deleteListener(listenerId);
        return "listner";
    }
}

package com.musicBackend.musicBackend.models.email;

public interface EmailSender {
    void send(String to, String email);
}

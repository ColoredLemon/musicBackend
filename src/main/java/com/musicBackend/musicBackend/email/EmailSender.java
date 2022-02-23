package com.musicBackend.musicBackend.email;

public interface EmailSender {
    void send(String to, String email);
}
